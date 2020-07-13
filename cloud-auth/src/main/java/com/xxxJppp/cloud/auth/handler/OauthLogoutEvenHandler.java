package com.xxxJppp.cloud.auth.handler;

import cn.hutool.core.collection.CollUtil;
import com.xxxJppp.cloud.common.model.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 在验证过程中发生异常会触发此类事件
 *
 * @author xxxJppp
 * @date 2020/4/29 21:23
 */
@Slf4j
@Component
public class OauthLogoutEvenHandler implements ApplicationListener<LogoutSuccessEvent> {
    @Override
    public void onApplicationEvent(LogoutSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        if (CollUtil.isNotEmpty(authentication.getAuthorities())) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SecurityUser) {
                // 此处可以异步调用消息系统 发送消息或者邮件
                log.info("用户：{} 登出成功", ((SecurityUser) principal).getUsername());
            }
        }
    }
}
