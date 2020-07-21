package com.xxxJppp.cloud.data.datasource;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.xxxJppp.cloud.data.properties.DatabaseProperties;
import com.xxxJppp.cloud.data.servlet.TenantWebMvcConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * MybatisPlus配置 常用重用拦截器，zuihou.database.multiTenantType=任意模式 都需要实例出来
 * <p>
 * 拦截器执行一定是：
 * WriteInterceptor > DataScopeInterceptor > PaginationInterceptor
 *
 * @author zuihou
 * @date 2018/10/24
 */
@Slf4j
public abstract class BaseMybatisConfiguration {
    protected final DatabaseProperties databaseProperties;

    public BaseMybatisConfiguration(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }


    /**
     * 演示环境权限拦截器
     *
     * @return
     */
   /* @Bean
    @Order(15)
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = DatabaseProperties.PREFIX, name = "isNotWrite", havingValue = "true")
    public WriteInterceptor getWriteInterceptor() {
        return new WriteInterceptor();
    }*/


    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Order(5)
    @Bean
    @ConditionalOnMissingBean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(databaseProperties.getLimit());
        List<ISqlParser> sqlParserList = new ArrayList<>();

        if (this.databaseProperties.getIsBlockAttack()) {
            // 攻击 SQL 阻断解析器 加入解析链
            sqlParserList.add(new BlockAttackSqlParser());
        }

        tenantSqlParser(sqlParserList);

        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }


    /**
     * Mybatis Plus 注入器
     *
     * @return
     */
    @Bean("myMetaObjectHandler")
    @ConditionalOnMissingBean
    public MetaObjectHandler getMyMetaObjectHandler() {
        DatabaseProperties.Id id = databaseProperties.getId();
        return new MyMetaObjectHandler(id.getWorkerId(), id.getDataCenterId());
    }

    @Bean
    public TenantWebMvcConfigurer getTenantWebMvcConfigurer() {
        return new TenantWebMvcConfigurer();
    }

    /**
     * 租户sql解析器
     * @param sqlParserList
     */
    protected abstract void tenantSqlParser(List<ISqlParser> sqlParserList);
}
