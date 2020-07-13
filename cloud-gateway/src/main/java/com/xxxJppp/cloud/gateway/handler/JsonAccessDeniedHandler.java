package com.xxxJppp.cloud.gateway.handler;

import com.xxxJppp.cloud.common.enums.ResultEnum;
import com.xxxJppp.cloud.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
/**
 * 403拒绝访问异常处理
 *
 * @author xxxJppp
 * @date 2020/4/29 22:10
*/
@Slf4j
public class JsonAccessDeniedHandler implements ServerAccessDeniedHandler {

    private static final String INVALID = "无效的token拒绝访问";

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException e) {
        return ResponseUtil.failed(exchange, ResultEnum.ERROR.getCode(), INVALID);
    }

}
