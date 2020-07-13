package com.xxxJppp.cloud.gateway.config;

import com.xxxJppp.cloud.gateway.handler.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 特殊路由配置信息
 *
 * @author xxxJppp
 * @date 2020/4/29 22:11
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RouterFunctionConfiguration {

    private static final String FALLBACK = "/fallback";
    private static final String CODE = "/code";

    private final HystrixFallbackHandler hystrixFallbackHandler;
    private final SwaggerResourceHandler swaggerResourceHandler;
    private final SwaggerSecurityHandler swaggerSecurityHandler;
    private final SwaggerUiHandler swaggerUiHandler;
    private final ValidateCodeHandler validateCodeHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.path(FALLBACK)
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), hystrixFallbackHandler)
                .andRoute(
                        RequestPredicates.GET(CODE).and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        validateCodeHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }
}
