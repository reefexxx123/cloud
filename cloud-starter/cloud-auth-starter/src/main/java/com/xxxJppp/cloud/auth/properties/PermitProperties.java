package com.xxxJppp.cloud.auth.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 配置需要放权的url白名单
 *
 * @author xxxJppp
 * @date 2020/5/2 11:21
 */
@Data
public class PermitProperties {
    /**
     * 监控中心和swagger需要访问的url
     */
    private static final String[] ENDPOINTS = {
            "/actuator/**",
            "/fallback",
            "/swagger-resources/**",
            "/webjars/**",
            "/druid/**",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js",
            "/*.js",
            "/*.css",
            "/*.html",
            "/**/favicon.ico",
            "/webjars/**",
            "/*/api-docs",
            "/css/**",
            "/js/**",
            "/images/**"
    };

    /**
     * 设置不用认证的url
     */
    private String[] httpUrls = {};

    public String[] getUrls() {
        if (httpUrls == null || httpUrls.length == 0) {
            return ENDPOINTS;
        }
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(ENDPOINTS));
        list.addAll(Arrays.asList(httpUrls));
        return list.toArray(new String[list.size()]);
    }
}
