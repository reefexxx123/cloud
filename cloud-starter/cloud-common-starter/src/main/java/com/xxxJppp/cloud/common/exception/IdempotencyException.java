package com.xxxJppp.cloud.common.exception;

/**
 * 幂等性异常
 *
 * @author xxxJppp
 * @date 2020/5/2 11:22
 */
public class IdempotencyException extends BaseException {
    public IdempotencyException(String message) {
        super(message);
    }

    public IdempotencyException(String message, Throwable e) {
        super(message, e);
    }

    public IdempotencyException(String message, int code) {
        super(message, code);
    }

    public IdempotencyException(String message, int code, Throwable e) {
        super(message, code, e);
    }
}
