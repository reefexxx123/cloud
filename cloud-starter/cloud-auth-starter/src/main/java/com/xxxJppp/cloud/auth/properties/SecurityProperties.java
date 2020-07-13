package com.xxxJppp.cloud.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * SecurityProperties
 *
 * @author xxxJppp
 * @date 2020/5/2 11:21
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "xxxjppp.cloud.oauth2.security")
public class SecurityProperties {
    /**
     * 是否开启权限认证 总开关
     */
    private boolean enabled = false;

    private AuthProperties auth = new AuthProperties();

    private PermitProperties ignore = new PermitProperties();

}
