package com.xxxJppp.cloud.tenant.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * 动态数据源
 *
 * @author xxxJppp
 * @version 1.0
 * @Description 动态数据源
 * @date 2020/5/18 23:26
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    private ApplicationContext applicationContext;

    @Lazy
    @Autowired
    private DynamicDataSourceSummoner dynamicDataSourceSummoner;

    /**
     * 如果希望所有数据源在启动配置时就加载好，这里通过设置数据源Key值来切换数据，定制这个方法
     *
     * @return
     */
    @Override
    protected String determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }


    /**
     * 如果不希望数据源在启动配置时就加载好，可以定制这个方法，从任何你希望的地方读取并返回数据源
     * 比如从数据库、文件、外部接口等读取数据源信息，并最终返回一个DataSource实现类对象即可
     *
     * @return
     */
    @Override
    protected DataSource determineTargetDataSource() {
        /*String tenantKey = DynamicDataSourceContextHolder.getDataSourceKey();
        String beanKey = DataSourceUtil.getDataSourceBeanKey(tenantKey);

        log.info(" beanKey " + beanKey);
        if (!StringUtils.hasText(tenantKey) || applicationContext.containsBean(beanKey)) {
            return super.determineTargetDataSource();
        }
        log.info("tenantCode exist {}", dynamicDataSourceSummoner.existTenant(tenantKey));
        if (dynamicDataSourceSummoner.existTenant(tenantKey)) {
            dynamicDataSourceSummoner.registerDynamicDataSources();
        } else {
            throw new IllegalStateException("租户不存在");
        }*/
        return super.determineTargetDataSource();
    }
}
