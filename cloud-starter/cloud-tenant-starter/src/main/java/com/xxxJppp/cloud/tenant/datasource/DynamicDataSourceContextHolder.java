package com.xxxJppp.cloud.tenant.datasource;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.xxxJppp.cloud.common.constant.CommonConstant;
import com.xxxJppp.cloud.common.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author xxxJppp
 * @version 1.0
 * @date 2020/7/20
 */
@UtilityClass
public class DynamicDataSourceContextHolder {

    /**
     * Maintain variable for every thread, to avoid effect other thread
     */
    private static final ThreadLocal<String> contextHolder = new TransmittableThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return CommonConstant.DEFAULT_DATA_SOURCE_BEAN_KEY;
        }
    };

    /**
     * All DataSource List
     */
    public static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 切换数据源
     * @param key  数据源
     */
    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    /**
     * 重置数据源
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }


    /**
     * 判断是否包含数据源
     * @param key   数据源
     * @return
     */
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

    /**
     * 添加数据源Keys
     * @param keys
     * @return
     */
    public static boolean addDataSourceKeys(Collection<? extends Object> keys) {
        return dataSourceKeys.addAll(keys);
    }
}
