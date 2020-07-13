package com.xxxJppp.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 请求时间过滤<br>
 *
 * @author xxxJppp
 * @version v1.0.0
 */
@Component
public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {
    private static final Logger log = LoggerFactory.getLogger(RequestTimeGatewayFilterFactory.class);
    private static final String COUNT_START_TIME = "countStartTime";
    private static final String ENABLED = "enabled";

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(ENABLED);
    }

    public RequestTimeGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!config.isEnabled()) {
                return chain.filter(exchange);
            }
            exchange.getAttributes().put(COUNT_START_TIME, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(COUNT_START_TIME);
                        if (Objects.nonNull(startTime)) {
                            ServerHttpRequest request = exchange.getRequest();
                            StringBuilder sb = new StringBuilder(request.getURI().getRawPath())
                                    .append(" 请求时间: ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            sb.append(" 请求参数: ").append(request.getQueryParams());
                            log.info(sb.toString());
                        }
                    })
            );
        };
    }

    public static class Config {
        /**
         * 控制是否开启统计
         */
        private boolean enabled;

        public Config() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
