package com.xxxJppp.cloud.tenant.datasource.aspect;

import com.xxxJppp.cloud.common.context.TenantContextHolder;
import com.xxxJppp.cloud.tenant.datasource.DynamicDataSourceContextHolder;
import com.xxxJppp.cloud.tenant.datasource.DynamicDataSourceSummoner;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@AllArgsConstructor
public class DynamicDataSourceAspect {

    private DynamicDataSourceSummoner dynamicDataSourceSummoner;

    /**
     * 切换数据源应发生在事务之前，否则仍然会使用默认数据源，
     * 故数据源切换放在controller层（默认事务应放到service层）
     */
    @Pointcut("@annotation(com.xxxJppp.cloud.tenant.datasource.annotation.DynamicSwitchDataSource)")
    public void dataSourcePointCut() {
    }

    @Before("dataSourcePointCut()")
    public void beforeExecute() {
        String tenantId = getTenantId();
        if (tenantId != null) {
            dynamicDataSourceSummoner.checkAndDynamicCreateShardingDataSource(tenantId);
        }
    }

    @After("dataSourcePointCut()")
    public void afterExecute() {
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }

    private String getTenantId() {
        return TenantContextHolder.getTenant();
    }
}
