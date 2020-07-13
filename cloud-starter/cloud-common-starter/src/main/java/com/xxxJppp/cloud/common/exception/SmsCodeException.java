package com.xxxJppp.cloud.common.exception;

/**
 * 发送短信异常
 *
 * @author xxxJppp
 * @date 2020/5/2 16:40
 */
public class SmsCodeException extends BaseException {
    public SmsCodeException(String message) {
        super(message);
    }

    public SmsCodeException(String message, Throwable e) {
        super(message, e);
    }

    public SmsCodeException(String message, int code) {
        super(message, code);
    }

    public SmsCodeException(String message, int code, Throwable e) {
        super(message, code, e);
    }
}
