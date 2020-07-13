package com.xxxJppp.cloud.gateway.filter;

import com.xxxJppp.cloud.gateway.swagger.SwaggerAggProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

/**
 * SwaggerHeader过滤
 *
 * @author xxxJppp
 * @date 2020/4/29 22:13
 */
@Slf4j
@Component
@AllArgsConstructor
public class SwaggerHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    private final SwaggerAggProperties swaggerAggProperties;

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, swaggerAggProperties.getApiDocsPath())) {
                return chain.filter(exchange);
            }
            String basePath = path.substring(0, path.lastIndexOf(swaggerAggProperties.getApiDocsPath()));
            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}
