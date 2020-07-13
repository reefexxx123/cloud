package com.xxxJppp.cloud.common.exception;


/**
 * 消息异常
 *
 * @author xxxJppp
 * @date 2020/5/13 09:53
 */
public class MessageException extends BaseException {
    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable e) {
        super(message, e);
    }

    public MessageException(String message, int code) {
        super(message, code);
    }

    public MessageException(String message, int code, Throwable e) {
        super(message, code, e);
    }
}
