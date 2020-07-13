package com.xxxJppp.cloud.common.exception;

/**
 * 业务异常
 *
 * @author xxxJppp
 * @date 2020/5/2 11:21
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 6610083281801529147L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
    }

    public BusinessException(String message, int code) {
        super(message, code);
    }

    public BusinessException(String message, int code, Throwable e) {
        super(message, code, e);
    }
}
