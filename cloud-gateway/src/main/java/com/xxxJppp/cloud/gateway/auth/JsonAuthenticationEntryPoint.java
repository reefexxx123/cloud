package com.xxxJppp.cloud.gateway.auth;

import com.xxxJppp.cloud.common.enums.ResultEnum;
import com.xxxJppp.cloud.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
/**
 * 401未授权异常处理
 *
 * @author xxxJppp
 * @date 2020/4/29 22:10
*/
@Slf4j
public class JsonAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    private static final String UN_AUTHORIZED = "未授权不能访问";

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        log.info("请求路径：{} 未授权不能访问", exchange.getRequest().getPath());
        return ResponseUtil.failed(exchange, ResultEnum.UNAUTHORIZED.getCode(), UN_AUTHORIZED);
    }
}
