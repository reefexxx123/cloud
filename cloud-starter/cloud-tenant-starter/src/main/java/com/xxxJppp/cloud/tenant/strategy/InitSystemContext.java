package com.xxxJppp.cloud.tenant.strategy;

import com.xxxJppp.cloud.common.utils.BizAssert;
import com.xxxJppp.cloud.tenant.properties.TenantProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 初始化系统上下文
 *
 * @author xxxJppp
 * @date 2020年03月15日11:58:47
 */
@Component
public class InitSystemContext {
    private final Map<String, InitSystemStrategy> initSystemStrategyMap = new ConcurrentHashMap<>();
    private final TenantProperties tenantProperties;

    @Autowired
    public InitSystemContext(Map<String, InitSystemStrategy> strategyMap, TenantProperties tenantProperties) {
        strategyMap.forEach(this.initSystemStrategyMap::put);
        this.tenantProperties = tenantProperties;
    }

    /**
     * 初始化系统
     *
     * @param tenant
     */
    public boolean init(String tenant) {
        InitSystemStrategy initSystemStrategy = initSystemStrategyMap.get(tenantProperties.getMultiTenantType().name());
        BizAssert.notNull(initSystemStrategy, String.format("您配置的租户模式:{}不可用", tenantProperties.getMultiTenantType().name()));
        return initSystemStrategy.init(tenant);
    }

    /**
     * 重置系统
     *
     * @param tenant
     */
    public boolean reset(String tenant) {
        InitSystemStrategy initSystemStrategy = initSystemStrategyMap.get(tenantProperties.getMultiTenantType().name());
        BizAssert.notNull(initSystemStrategy, String.format("您配置的租户模式:{}不可用", tenantProperties.getMultiTenantType().name()));
        return initSystemStrategy.reset(tenant);
    }

    /**
     * 删除租户数据
     *
     * @param tenantCodeList
     */
    public boolean delete(List<String> tenantCodeList) {
        InitSystemStrategy initSystemStrategy = initSystemStrategyMap.get(tenantProperties.getMultiTenantType().name());
        BizAssert.notNull(initSystemStrategy, String.format("您配置的租户模式:{}不可用", tenantProperties.getMultiTenantType().name()));

        return initSystemStrategy.delete(tenantCodeList);
    }
}
