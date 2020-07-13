package com.xxxJppp.cloud.gateway.service;

import com.xxxJppp.cloud.common.exception.CaptchaException;
import com.xxxJppp.cloud.common.model.Result;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author xxxJppp
 */
public interface ValidateCodeService {
    /**
     * 生成验证码
     */
    Result createCapcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    void checkCapcha(String key, String value) throws CaptchaException;
}
