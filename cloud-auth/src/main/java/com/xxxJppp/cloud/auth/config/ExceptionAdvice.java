package com.xxxJppp.cloud.auth.config;

import com.xxxJppp.cloud.common.config.DefaultExceptionAdvice;
import com.xxxJppp.cloud.common.exception.BaseException;
import com.xxxJppp.cloud.common.model.Result;
import feign.codec.DecodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常处理
 *
 * @author xxxJppp
 * @date 2020/5/2 11:17
 */
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice extends DefaultExceptionAdvice {
    /**
     * AccessDeniedException异常处理返回json
     * 返回状态码:403
     */
    @ExceptionHandler({DecodeException.class})
    public Result<String> badDecodeException(BaseException e) {
        return Result.of(e.getMessage(), HttpStatus.FORBIDDEN.value(), "没有权限请求当前方法");
    }
}
