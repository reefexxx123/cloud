package com.xxxJppp.cloud.auth.config;

import com.xxxJppp.cloud.auth.component.CustomAuthenticationEntryPoint;
import com.xxxJppp.cloud.auth.service.IUserDetailsService;
import com.xxxJppp.cloud.auth.service.impl.UserDetailsServiceImpl;
import com.xxxJppp.cloud.common.utils.ResponseUtil;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DefaultSecurityHandlerConfig
 *
 * @author xxxJppp
 * @date 2020/4/30 09:05
 */
public class SecurityHandlerConfig {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
                ResponseUtil.failed(response, "无效的token拒绝访问");
            }
        };
    }

    @Bean
    public IUserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }


    @Bean
    @Primary
    @LoadBalanced //通过服务名来访问注册的服务
    public RestTemplate lbRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != HttpStatus.BAD_REQUEST.value()) {
                    super.handleError(response);
                }
            }
        });
        return restTemplate;
    }

    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint(){
        return new CustomAuthenticationEntryPoint();
    }

}
