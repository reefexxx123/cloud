package com.xxxJppp.cloud.tenant.datasource;

import cn.hutool.core.bean.BeanUtil;
import com.xxxJppp.cloud.common.enums.ResultEnum;
import com.xxxJppp.cloud.common.exception.BusinessException;
import com.xxxJppp.cloud.redis.repository.RedisService;
import com.xxxJppp.cloud.tenant.model.TenantDataSource;
import com.xxxJppp.cloud.tenant.properties.DataSourceProperties;
import com.xxxJppp.cloud.tenant.properties.TenantProperties;
import com.xxxJppp.cloud.tenant.service.ITenantDataSourceService;
import com.xxxJppp.cloud.tenant.utils.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class DynamicDataSourceSummoner implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @Autowired
    private DynamicDataSource dynamicDataSource;
    @Resource
    private ITenantDataSourceService defaultTenantDataSourceService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private TenantProperties tenantProperties;

    private static boolean loaded = false;

    /**
     * Spring加载完成后执行
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 防止重复执行
        if (!loaded) {
            loaded = true;
            try {
                registerDynamicDataSources();
            } catch (Exception e) {
                log.error("数据源初始化失败, Exception:", e);
            }
        }
    }

    /**
     * 从数据库读取租户的DB配置,并动态注入Spring容器
     */
    public void registerDynamicDataSources() {
        // 获取所有租户的DB配置
        List<TenantDataSource> tenantConfigEntities = defaultTenantDataSourceService.findAllUsedDataSource();
        if (CollectionUtils.isEmpty(tenantConfigEntities)) {
            throw new IllegalStateException("应用程序初始化失败,请先配置数据源");
        }
        // 把数据源bean注册到容器中
        addDataSourceBeans(tenantConfigEntities);
    }

    /**
     * 租户是否存在
     * @param tenantKey
     */
    public boolean existTenant(String tenantKey) {
        return defaultTenantDataSourceService.existTenant(tenantKey);
    }

    /**
     * 根据DataSource创建bean并注册到容器中
     */
    private void addDataSourceBeans(List<TenantDataSource> tenantConfigEntities) {
        Map<Object, Object> targetDataSources = new LinkedHashMap<>();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        for (TenantDataSource entity : tenantConfigEntities) {
            String beanKey = DataSourceUtil.getDataSourceBeanKey(entity.getTenantCode());
            TenantDataSource tenantDataSourceVO = (TenantDataSource) redisService.getCacheObject(beanKey);
            if (ObjectUtils.isEmpty(tenantDataSourceVO)) {
                tenantDataSourceVO = defaultTenantDataSourceService.findOneUsedDataSource(entity.getTenantCode());
            }
            if (!ObjectUtils.isEmpty(tenantDataSourceVO)) {
                if (applicationContext.containsBean(beanKey)) {
                    HikariDataSource existsDataSource = applicationContext.getBean(beanKey, HikariDataSource.class);
                    if (isSameDataSource(existsDataSource, entity)) {
                        continue;
                    }
                }
                //  组装bean
                creatAndRegist(beanFactory, targetDataSources, beanKey, entity);
            } else {
                log.error("非法的数据源连接：{}", entity.getTenantCode());
                throw new BusinessException("非法的数据源连接", ResultEnum.ERROR.getCode());
            }
        }
        //  将创建的map对象set到 targetDataSources；
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //  必须执行此操作，才会重新初始化AbstractRoutingDataSource 中的 resolvedDataSources，也只有这样，动态切换才会起效
        dynamicDataSource.afterPropertiesSet();
    }

    /**
     * 检查和动态创建数据源
     *
     * @param tenantName 数据源名称
     * @return void
     */
    public void checkAndDynamicCreateShardingDataSource(String tenantName) {
        if (StringUtils.isEmpty(tenantName)) {
            log.error("数据源为空");
            throw new BusinessException("数据源为空", ResultEnum.ERROR.getCode());
        }
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        Map<Object, Object> targetDataSources = new LinkedHashMap<>();
        String beanKey = DataSourceUtil.getDataSourceBeanKey(tenantName);
        TenantDataSource tenantDataSourceVO = (TenantDataSource) redisService.getCacheObject(beanKey);
        if (ObjectUtils.isEmpty(tenantDataSourceVO)) {
            tenantDataSourceVO = defaultTenantDataSourceService.findOneUsedDataSource(tenantName);
        }
        if (!applicationContext.containsBean(beanKey)) {
            creatAndRegist(beanFactory, targetDataSources, beanKey, tenantDataSourceVO);
        }
    }

    private void creatAndRegist(DefaultListableBeanFactory beanFactory, Map<Object, Object> targetDataSources, String beanKey, TenantDataSource tenantDataSourceVO) {
        //  组装bean
        HikariDataSource hikariDataSource = createHikariDataSource(tenantDataSourceVO);

        Map<String, Object> dataSourceVo = BeanUtil.beanToMap(hikariDataSource);
        BeanDefinition beanDefinition = defaultBeanDefinition(HikariDataSource.class, dataSourceVo);
        //  注册bean
        beanFactory.registerBeanDefinition(beanKey, beanDefinition);
        //  放入map中，注意一定是刚才创建bean对象
        targetDataSources.put(beanKey, hikariDataSource);
        this.redisService.setCacheObject(beanKey, tenantDataSourceVO);
    }


    /**
     * 组装数据源spring bean
     */
    private BeanDefinition defaultBeanDefinition(Class<?> beanClass, Map<?, ?> propertyValues) {

        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(beanClass);
        definition.setScope(BeanDefinition.SCOPE_SINGLETON);
        definition.setLazyInit(false);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        definition.setAutowireCandidate(true);

        if (propertyValues != null) {
            MutablePropertyValues mp = new MutablePropertyValues();
            mp.addPropertyValues(propertyValues);
            definition.setPropertyValues(mp);
        }
        return definition;
    }

    /**
     * 根据租户数据源信息 创建Hikari数据源
     *
     * @param tenantDataSourceVO 租户数据源信息
     */
    @Bean
    private HikariDataSource createHikariDataSource(TenantDataSource tenantDataSourceVO) {
        HikariDataSource newHikariDataSource = new HikariDataSource();
        newHikariDataSource.setDriverClassName(tenantDataSourceVO.getDataSourceDriver());
        newHikariDataSource.setJdbcUrl(tenantDataSourceVO.getDataSourceUrl());
        newHikariDataSource.setUsername(tenantDataSourceVO.getDataSourceUsername());
        newHikariDataSource.setPassword(tenantDataSourceVO.getDataSourcePassword());

        HikariDataSource hikariDataSource = dataSourceProperties.getHikari();
        newHikariDataSource.setConnectionTimeout(hikariDataSource.getConnectionTimeout());
        newHikariDataSource.setMinimumIdle(hikariDataSource.getMinimumIdle());
        newHikariDataSource.setMaximumPoolSize(hikariDataSource.getMaximumPoolSize());
        newHikariDataSource.setIdleTimeout(hikariDataSource.getIdleTimeout());
        newHikariDataSource.setMaxLifetime(hikariDataSource.getMaxLifetime());
        newHikariDataSource.setAutoCommit(true);
        newHikariDataSource.setConnectionTestQuery(hikariDataSource.getConnectionTestQuery());
        return newHikariDataSource;
    }


    /**
     * 判断Spring容器里面的DataSource与数据库的DataSource信息是否一致
     */
    private boolean isSameDataSource(HikariDataSource existsDataSource, TenantDataSource entity) {
        boolean sameUrl = Objects.equals(existsDataSource.getJdbcUrl(), DataSourceUtil.getJDBCUrl(entity.getDataSourceUrl()));
        if (!sameUrl) {
            return false;
        }
        boolean sameUser = Objects.equals(existsDataSource.getUsername(), entity.getDataSourceUsername());
        if (!sameUser) {
            return false;
        }
        try {
            return Objects.equals(existsDataSource.getPassword(), entity.getDataSourcePassword());
        } catch (Exception e) {
            log.error("数据源密码校验失败,Exception:{}", e);
            return false;
        }
    }
}
