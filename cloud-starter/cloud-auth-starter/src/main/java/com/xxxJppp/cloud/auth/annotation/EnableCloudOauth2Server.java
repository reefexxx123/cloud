package com.xxxJppp.cloud.auth.annotation;

import com.xxxJppp.cloud.auth.config.SecurityHandlerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启认证服务器和客户端
 *
 * @author xxxJppp
 * @date 2020/5/3 07:47
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({SecurityHandlerConfig.class})
public @interface EnableCloudOauth2Server {

}
