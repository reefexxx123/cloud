package com.xxxJppp.cloud.auth.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置注册
 *
 * @author xxxJppp
 **/
@Configuration
public class OAuth2FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new OAuth2FeignRequestInterceptor();
    }
}
