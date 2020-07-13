package com.xxxJppp.cloud.common.exception;

import com.xxxJppp.cloud.common.enums.ResultEnum;

import java.io.Serializable;

/**
 * 自定义异常
 *
 * @author xxxJppp
 * @date 2020/5/13 10:56
 */
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 6610083281801529147L;

    private String message;

    private int code = ResultEnum.ERROR.getCode();

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public BaseException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BaseException(String message, int code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
