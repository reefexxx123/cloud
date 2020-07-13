package com.xxxJppp.cloud.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * ValidateCodeException
 *
 * @author xxxJppp
 * @date 2020/6/15 11:21
*/
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }
}
