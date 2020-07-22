package com.xxxJppp.cloud.tenant.configuration;

import com.xxxJppp.cloud.common.constant.CommonConstant;
import com.xxxJppp.cloud.tenant.datasource.DynamicDataSource;
import com.xxxJppp.cloud.tenant.datasource.DynamicDataSourceSummoner;
import com.xxxJppp.cloud.tenant.datasource.aspect.DynamicDataSourceAspect;
import com.xxxJppp.cloud.tenant.properties.DataSourceProperties;
import com.xxxJppp.cloud.tenant.properties.TenantProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxJppp
 * @date: 2019/3/20 13:20
 * @description:
 */
@Slf4j
@Configuration
@MapperScan("com.xxxJppp.cloud.tenant.mapper")
@ComponentScan(basePackages = {"com.xxxJppp.cloud.tenant.service"})
@EnableConfigurationProperties(value = {TenantProperties.class, DataSourceProperties.class})
@ConditionalOnExpression("'DATASOURCE'.equals('${cloud.tenant.multiTenantType}')")
public class DynamicDataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    public DynamicDataSourceConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
        log.debug("检测到 cloud.tenant.multiTenantType=DATASOURCE，加载了 DynamicDataSourceConfiguration");
    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dataSource() {
        DynamicDataSource ds = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        HikariDataSource hikari = dataSourceProperties.getHikari();
        hikari.setJdbcUrl(dataSourceProperties.getUrl());
        hikari.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikari.setUsername(dataSourceProperties.getUsername());
        hikari.setPassword(dataSourceProperties.getPassword());
        ds.setDefaultTargetDataSource(hikari);
        dataSourceMap.put(CommonConstant.DEFAULT_DATA_SOURCE_BEAN_KEY, hikari);
        log.info("===>动态加载{}数据源", CommonConstant.DEFAULT_DATA_SOURCE_BEAN_KEY);
        ds.setTargetDataSources(dataSourceMap);
        return ds;
    }

    @Bean
    public DynamicDataSourceSummoner dynamicDataSourceSummoner() {
        return new DynamicDataSourceSummoner();
    }

    @Bean
    public DynamicDataSourceAspect dynamicDataSourceAspect() {
        return new DynamicDataSourceAspect(dynamicDataSourceSummoner());
    }
}
