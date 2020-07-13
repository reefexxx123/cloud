package com.xxxJppp.cloud.gateway.service.impl;

import cn.hutool.core.codec.Base64;
import com.google.code.kaptcha.Producer;
import com.xxxJppp.cloud.common.constant.CommonConstant;
import com.xxxJppp.cloud.common.exception.CaptchaException;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.utils.IdGeneratorUtil;
import com.xxxJppp.cloud.common.utils.StringUtils;
import com.xxxJppp.cloud.gateway.service.ValidateCodeService;
import com.xxxJppp.cloud.redis.repository.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FastByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 验证码实现处理
 *
 * @author xxxJppp
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    @Autowired
    private Producer producer;

    @Autowired
    private RedisService redisService;

    /**
     * 生成验证码
     */
    @Override
    public Result createCapcha() throws IOException, CaptchaException {
        // 生成验证码
        String capText = producer.createText();
        String capStr = capText.substring(0, capText.lastIndexOf("@"));
        String verifyCode = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage image = producer.createImage(capStr);
        // 保存验证码信息
        String uuid = IdGeneratorUtil.getIdStr();
        String verifyKey = CommonConstant.CAPTCHA_CODE_KEY + uuid;
        redisService.setCacheObject(verifyKey, verifyCode, CommonConstant.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            throw new CaptchaException("获取验证码失败");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("uuid", uuid);
        map.put("img", Base64.encode(os.toByteArray()));
        return Result.succeed(map);
    }

    /**
     * 校验验证码
     */
    @Override
    public void checkCapcha(String code, String uuid) throws CaptchaException {
        if (StringUtils.isEmpty(code)) {
            throw new CaptchaException("验证码不能为空");
        }
        if (StringUtils.isEmpty(uuid)) {
            throw new CaptchaException("验证码已失效");
        }
        String verifyKey = CommonConstant.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisService.getCacheObject(verifyKey);
        redisService.deleteObject(verifyKey);
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException("验证码错误");
        }
    }
}
