package com.xxxJppp.cloud.gateway.handler;

import com.xxxJppp.cloud.common.exception.CaptchaException;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.gateway.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * 验证码获取
 *
 * @author xxxJppp
 */
@Component
public class ValidateCodeHandler implements HandlerFunction<ServerResponse> {
    @Autowired
    private ValidateCodeService validateCodeService;

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Result result;
        try {
            result = validateCodeService.createCapcha();
        } catch (CaptchaException | IOException e) {
            return Mono.error(e);
        }
        return ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(result));
    }
}
