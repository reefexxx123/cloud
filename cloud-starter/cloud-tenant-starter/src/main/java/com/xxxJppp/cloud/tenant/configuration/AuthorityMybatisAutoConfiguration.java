package com.xxxJppp.cloud.tenant.configuration;


import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.xxxJppp.cloud.common.context.TenantContextHolder;
import com.xxxJppp.cloud.common.enums.MultiTenantTypeEnum;
import com.xxxJppp.cloud.data.datasource.BaseMybatisConfiguration;
import com.xxxJppp.cloud.data.parsers.DynamicTableNameParser;
import com.xxxJppp.cloud.data.properties.DatabaseProperties;
import com.xxxJppp.cloud.tenant.properties.TenantProperties;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 配置一些 Mybatis 常用重用拦截器
 *
 * @author 瑞夫
 * @version 1.0
 * @date 2020/7/20
 */
@Configuration
@Slf4j
@EnableConfigurationProperties({DatabaseProperties.class, TenantProperties.class})
public class AuthorityMybatisAutoConfiguration extends BaseMybatisConfiguration {

    private TenantProperties tenantProperties;

    public AuthorityMybatisAutoConfiguration(DatabaseProperties databaseProperties, TenantProperties tenantProperties) {
        super(databaseProperties);
        this.tenantProperties = tenantProperties;
    }

    /**
     * 租户sql解析器
     * @param sqlParserList
     */
    @Override
    protected void tenantSqlParser(List<ISqlParser> sqlParserList) {
        log.info("已为您开启{}租户模式", tenantProperties.getMultiTenantType().getDescribe());
        //动态"表名" 插件 来实现 租户schema切换 加入解析链
        if (MultiTenantTypeEnum.SCHEMA.eq(this.tenantProperties.getMultiTenantType())) {
            DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser(tenantProperties.getTenantDatabasePrefix());
            sqlParserList.add(dynamicTableNameParser);
        } else if (MultiTenantTypeEnum.COLUMN.eq(this.tenantProperties.getMultiTenantType())) {
            TenantSqlParser tenantSqlParser = new TenantSqlParser();
            tenantSqlParser.setTenantHandler(new TenantHandler() {
                @Override
                public Expression getTenantId(boolean where) {
                    // 该 where 条件 3.2.0 版本开始添加的，用于区分是否为在 where 条件中使用
                    return new StringValue(TenantContextHolder.getTenant());
                }

                @Override
                public String getTenantIdColumn() {
                    return tenantProperties.getTenantIdColumn();
                }

                @Override
                public boolean doTableFilter(String tableName) {
                    // 这里可以判断是否过滤表
                    return false;
                }
            });
            sqlParserList.add(tenantSqlParser);
        }
    }
}
