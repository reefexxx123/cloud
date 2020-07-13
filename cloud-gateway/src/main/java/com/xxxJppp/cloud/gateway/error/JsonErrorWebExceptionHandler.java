package com.xxxJppp.cloud.gateway.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理
 *
 * @author xxxJppp
 * @version 1.0
 * @date 2020/7/7
 */
@Slf4j
public class JsonErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {
    public JsonErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                        ResourceProperties resourceProperties,
                                        ErrorProperties errorProperties,
                                        ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Throwable error = super.getError(request);
        Map<String, Object> errorAttributes = new HashMap<>(8);
        errorAttributes.put("message", error.getMessage());
        if (error instanceof InvalidTokenException) {
            errorAttributes.put("code", HttpStatus.UNAUTHORIZED.value());
        } else if (error instanceof ResponseStatusException) {
            ResponseStatusException exception = (ResponseStatusException) error;
            errorAttributes.put("code", exception.getStatus().value());
        } else {
            errorAttributes.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        errorAttributes.put("method", request.methodName());
        errorAttributes.put("path", request.path());
        log.info("请求路径：{} 错误码：{} 错误信息：{}", request.path(), errorAttributes.get("code") ,error.getMessage());
        return errorAttributes;
    }

    @Override
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        boolean includeStackTrace = isIncludeStackTrace(request, MediaType.ALL);
        Map<String, Object> error = getErrorAttributes(request, includeStackTrace);
        return ServerResponse.status(getHttpStatus(error))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(error));
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        return Integer.parseInt(errorAttributes.get("code").toString());
    }
}
