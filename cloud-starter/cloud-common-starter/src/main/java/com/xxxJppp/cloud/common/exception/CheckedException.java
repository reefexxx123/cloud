package com.xxxJppp.cloud.common.exception;

/**
 * 自定义检查异常
 *
 * @author xxxJppp
 * @date 2020/5/2 16:40
 */
public class CheckedException extends BaseException {

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable e) {
        super(message, e);
    }

    public CheckedException(String message, int code) {
        super(message, code);
    }

    public CheckedException(String message, int code, Throwable e) {
        super(message, code, e);
    }
}
