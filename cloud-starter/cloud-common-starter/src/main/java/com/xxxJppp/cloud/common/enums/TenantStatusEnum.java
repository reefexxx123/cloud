package com.xxxJppp.cloud.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

/**
 * <p>
 * 实体注释中生成的类型枚举
 * 企业
 * </p>
 *
 * @author zuihou
 * @date 2019-10-25
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TenantStatusEnum {

    /**
     * NORMAL="正常"
     */
    NORMAL("正常"),
    /**
     * FORBIDDEN="禁用"
     */
    FORBIDDEN("禁用"),
    /**
     * WAITING="待审核"
     */
    WAITING("待审核"),
    /**
     * REFUSE="拒绝"
     */
    REFUSE("拒绝"),
    DELETE("已删除"),
    ;

    private String desc;


    public static TenantStatusEnum match(String val, TenantStatusEnum def) {
        return Stream.of(values()).parallel().filter((item) -> item.name().equalsIgnoreCase(val)).findAny().orElse(def);
    }

    public static TenantStatusEnum get(String val) {
        return match(val, null);
    }

}
