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
public enum TenantTypeEnum {

    /**
     * CREATE="创建"
     */
    CREATE("创建"),
    /**
     * REGISTER="注册"
     */
    REGISTER("注册"),
    ;

    private String desc;


    public static TenantTypeEnum match(String val, TenantTypeEnum def) {
        return Stream.of(values()).parallel().filter((item) -> item.name().equalsIgnoreCase(val)).findAny().orElse(def);
    }

    public static TenantTypeEnum get(String val) {
        return match(val, null);
    }


}
