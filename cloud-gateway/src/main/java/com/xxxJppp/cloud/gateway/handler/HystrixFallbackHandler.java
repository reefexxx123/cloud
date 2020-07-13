package com.xxxJppp.cloud.gateway.handler;

import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CACHED_REQUEST_BODY_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;

/**
 * Hystrix 降级处理
 *
 * @author xxxJppp
 * @date 2020/4/29 22:11
 */
@Slf4j
@Component
public class HystrixFallbackHandler implements HandlerFunction<ServerResponse> {

    private static final int DEFAULT_PORT = 9700;

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Optional<Object> originalUris = serverRequest.attribute(GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        Optional<InetSocketAddress> socketAddress = serverRequest.remoteAddress();

        originalUris.ifPresent(originalUri -> log.error("网关执行请求:{}失败,请求主机: {},请求数据:{} hystrix服务降级处理", null, originalUri,
                socketAddress.orElse(new InetSocketAddress(DEFAULT_PORT)).getHostString(), buildMessage(serverRequest)));

        return ServerResponse
                .status(HttpStatus.OK.value())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(Result.failed("服务异常,请稍后重试")));
    }

    private String buildMessage(ServerRequest request) {
        StringBuilder message = new StringBuilder("[");
        message.append(request.methodName());
        message.append(" ");
        message.append(request.uri());
        MultiValueMap<String, String> params = request.queryParams();
        Map<String, String> map = params.toSingleValueMap();
        if (map.size() > 0) {
            message.append(" 请求参数: ");
            String serialize = JsonUtil.serialize(message);
            message.append(serialize);
        }
        Object requestBody = request.exchange().getAttribute(CACHED_REQUEST_BODY_ATTR);
        if (Objects.nonNull(requestBody)) {
            message.append(" 请求body: ");
            message.append(requestBody.toString());
        }
        message.append("]");
        return message.toString();
    }
}
