package com.xxxJppp.cloud.common.exception;

/**
 * 分布式锁异常
 *
 * @author xxxJppp
 * @date 2020/5/2 11:22
 */
public class LockException extends BaseException {

    public LockException(String message) {
        super(message);
    }

    public LockException(String message, Throwable e) {
        super(message, e);
    }

    public LockException(String message, int code) {
        super(message, code);
    }

    public LockException(String message, int code, Throwable e) {
        super(message, code, e);
    }
}
