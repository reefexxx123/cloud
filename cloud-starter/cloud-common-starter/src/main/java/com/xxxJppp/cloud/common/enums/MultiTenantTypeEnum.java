package com.xxxJppp.cloud.common.enums;

import lombok.Getter;

/**
 * 多租户类型
 * <p>
 * NONE、COLUMN、SCHEMA DATASOURCE 模式
 * <p>
 * @author 瑞夫
 * @version 1.0
 * @date 2020/7/18
 */
@Getter
public enum MultiTenantTypeEnum {
    NONE("非租户模式"),
    /**
     * 字段模式
     * 在sql中拼接 tenant_code 字段
     */
    COLUMN("字段模式"),
    /**
     * 独立schema模式
     * 在sql中拼接 数据库 schema
     */
    SCHEMA("独立schema模式"),
    /**
     * 独立数据源模式
     * <p>
     * 该模式不开源，购买咨询作者。
     */
    DATASOURCE("独立数据源模式"),
    ;
    String describe;


    MultiTenantTypeEnum(String describe) {
        this.describe = describe;
    }

    public boolean eq(String val) {
        return this.name().equalsIgnoreCase(val);
    }

    public boolean eq(MultiTenantTypeEnum val) {
        if (val == null) {
            return false;
        }
        return eq(val.name());
    }
}
