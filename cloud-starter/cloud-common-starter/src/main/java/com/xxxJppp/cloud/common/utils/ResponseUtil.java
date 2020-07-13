package com.xxxJppp.cloud.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.xxxJppp.cloud.common.model.Result;
import lombok.NonNull;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * 自定义返回util
 *
 * @author xxxJppp
 * @date 2020/5/2 11:22
 */
public class ResponseUtil {
    private static final Gson GSON = new Gson();

    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 通过流写到前端
     *
     * @param response   response
     * @param msg        返回信息
     * @param httpStatus 返回状态码
     */
    public static void writeResponse(HttpServletResponse response,
                                     String msg,
                                     int httpStatus) throws IOException {
        Result<String> result = Result.failed(httpStatus, msg);
        writeResponse(response, result);
    }

    /**
     * 通过流写到前端
     *
     * @param response response
     * @param obj      数据对象
     */
    public static void success(HttpServletResponse response, @NonNull Object obj) throws IOException {
        Result<String> result = Result.succeed(obj.toString());
        writeResponse(response, result);
    }

    /**
     * 通过流写到前端
     *
     * @param response response
     * @param msg      数据
     */
    public static void failed(HttpServletResponse response, String msg) throws IOException {
        Result<String> result = Result.failed(msg);
        writeResponse(response, result);
    }

    /**
     * 功能描述
     *
     * @param response response
     * @param result   result
     * @author xxxJppp
     * @date 2020/6/1 14:50
     */
    private static void writeResponse(HttpServletResponse response, Result<String> result) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try (Writer writer = response.getWriter()) {
            writer.write(GSON.toJson(result));
            writer.flush();
        }
    }

    /**
     * webflux返回json对象
     *
     * @param exchange   exchange
     * @param httpStatus 状态
     * @param msg        数据
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @author xxxJppp
     * @date 2020/6/1 14:48
     */
    public static Mono<Void> writeResponse(ServerWebExchange exchange, int httpStatus, String msg) {
        Result<String> result = Result.failed(httpStatus, msg);
        return writeResponse(exchange, httpStatus, result);
    }

    /**
     * 失败返回
     *
     * @param exchange exchange
     * @param msg      数据
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @author xxxJppp
     * @date 2020/6/1 14:49
     */
    public static Mono<Void> failed(ServerWebExchange exchange, String msg) {
        Result<String> result = Result.failed(msg);
        return writeResponse(exchange, HttpStatus.INTERNAL_SERVER_ERROR.value(), result);
    }

    /**
     * 失败返回
     *
     * @param exchange   exchange
     * @param httpStatus httpStatus
     * @param msg        msg
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @author xxxJppp
     * @date 2020/6/1 14:52
     */
    public static Mono<Void> failed(ServerWebExchange exchange, int httpStatus, String msg) {
        Result<String> result = Result.failed(httpStatus, msg);
        return writeResponse(exchange, httpStatus, result);
    }

    /**
     * 写会数据
     *
     * @param exchange   exchange
     * @param httpStatus httpStatus
     * @param result     result
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @author xxxJppp
     * @date 2020/6/1 14:53
     */
    public static Mono<Void> writeResponse(ServerWebExchange exchange, int httpStatus, Result<String> result) {
        if (httpStatus == 0) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.valueOf(httpStatus));
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        DataBufferFactory dataBufferFactory = response.bufferFactory();
        DataBuffer buffer = dataBufferFactory.wrap(JSONObject.toJSONString(result).getBytes(Charset.defaultCharset()));
        return response.writeWith(Mono.just(buffer)).doOnError((error) -> DataBufferUtils.release(buffer));
    }
}
