package com.xxxJppp.cloud.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 租户holder
 *
 * @author xxxJppp
 * @date 2020/4/29 17:18
 */
public class TenantContextHolder {
    /**
     * 支持父子线程之间的数据传递
     */
    private static final ThreadLocal<String> CONTEXT = new TransmittableThreadLocal<>();

    public static void setTenant(String tenant) {
        CONTEXT.set(tenant);
    }

    public static String getTenant() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
