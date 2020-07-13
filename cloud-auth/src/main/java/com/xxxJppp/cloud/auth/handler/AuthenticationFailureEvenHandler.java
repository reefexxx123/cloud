package com.xxxJppp.cloud.auth.handler;

import com.xxxJppp.cloud.common.model.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 在验证过程中发生异常会触发此类事件
 *
 * @author xxxJppp
 * @date 2020/4/29 21:23
 */
@Slf4j
@Component
public class AuthenticationFailureEvenHandler implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        AuthenticationException authenticationException = event.getException();
        Authentication authentication = (Authentication) event.getSource();
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUser) {
            // 此处也可以异步调用消息系统发送登录失败
            log.info("用户：{} 登录失败，异常：{}", ((SecurityUser) principal).getUsername(), authenticationException.getLocalizedMessage());
        }
    }
}
