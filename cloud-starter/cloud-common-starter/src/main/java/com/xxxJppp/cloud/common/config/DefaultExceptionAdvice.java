package com.xxxJppp.cloud.common.config;

import com.xxxJppp.cloud.common.enums.ResultEnum;
import com.xxxJppp.cloud.common.exception.*;
import com.xxxJppp.cloud.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 异常通用处理
 *
 * @author xxxJppp
 * @date 2020/5/2 09:12
 */
@Slf4j
public class DefaultExceptionAdvice {

    @ExceptionHandler({LockException.class})
    public Result<String> lockException(NativeWebRequest request, LockException e) {
        printException(request, e);
        return Result.failed(ResultEnum.LOCK_EXCEPTION.getCode(), e.getMessage());
    }

    @ExceptionHandler({IdempotencyException.class})
    public Result<String> idempotencyException(NativeWebRequest request, IdempotencyException e) {
        printException(request, e);
        return Result.failed(ResultEnum.IDEMPOTENCY_EXCEPTION.getCode(), e.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    public Result<String> businessException(NativeWebRequest request, BusinessException e) {
        printException(request, e);
        return Result.failed(ResultEnum.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler({BaseException.class})
    public Result<String> badBaseException(NativeWebRequest request, BaseException e) {
        printException(request, e);
        return Result.failed(ResultEnum.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(NativeWebRequest request, Exception e) {
        printException(request, e);
        return Result.failed(ResultEnum.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public Result<String> badRequestException(NativeWebRequest request, IllegalArgumentException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.BAD_REQUEST.value(), "参数解析失败");
    }

    @ExceptionHandler({AccessDeniedException.class})
    public Result<String> badMethodExpressException(NativeWebRequest request, AccessDeniedException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.FORBIDDEN.value(), "没有权限请求当前方法");
    }

    @ExceptionHandler(value = BindException.class)
    public Result<String> handleBindException(BindException ex) {
        String msg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return Result.of(msg, HttpStatus.FORBIDDEN.value(), "参数校验错误");
    }

    @ExceptionHandler({MessageException.class})
    public Result<String> badMessageException(NativeWebRequest request, MessageException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.FORBIDDEN.value(), "发送消息异常");
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public Result<String> badUsernameNotFoundException(NativeWebRequest request, UsernameNotFoundException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.FORBIDDEN.value(), "错误");
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result<String> handleHttpRequestMethodNotSupportedException(NativeWebRequest request, HttpRequestMethodNotSupportedException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value(), "不支持当前请求方法");
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result<String> handleHttpMediaTypeNotSupportedException(NativeWebRequest request, HttpMediaTypeNotSupportedException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "不支持当前媒体类型");
    }

    @ExceptionHandler({SQLException.class})
    public Result<String> handleSQLException(NativeWebRequest request, SQLException e) {
        printException(request, e);
        return Result.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "SQLException异常");
    }

    /**
     * 打印异常
     *
     * @param request request
     * @param e       e
     * @author xxxJppp
     * @date 2020/6/19 11:35
     */
    private void printException(NativeWebRequest request, Exception e) {
        HttpServletRequest nativeRequest = request.getNativeRequest(HttpServletRequest.class);
        if (Objects.nonNull(nativeRequest)) {
            String uri = nativeRequest.getRequestURI();
            String queryString = nativeRequest.getQueryString();
            log.error("请求路径: " + uri + "   请求参数: " + queryString, e);
        } else {
            log.error("", e);
        }
    }
}
