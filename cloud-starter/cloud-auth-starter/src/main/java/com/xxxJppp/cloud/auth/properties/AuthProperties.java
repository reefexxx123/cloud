package com.xxxJppp.cloud.auth.properties;

import lombok.Data;

/**
 * 认证配置
 *
 * @author xxxJppp
 * @date 2020/4/30 08:52
 */
@Data
public class AuthProperties {
    /**
     * 配置要认证的url（默认不需要配置）
     * <p>
     * 优先级大于忽略认证配置`taotao.security.ignore.httpUrls`
     * 意思是如果同一个url同时配置了`忽略认证`和`需要认证`，则该url还是会被认证
     */
    private String[] httpUrls = {};

    /**
     * token自动续签配置（目前只有redis实现）
     */
    private RenewProperties renew = new RenewProperties();

    /**
     * url权限配置
     */
    private UrlPermissionProperties urlPermission = new UrlPermissionProperties();
}
