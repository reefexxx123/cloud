package com.xxxJppp.cloud.auth.annotation;

import com.xxxJppp.cloud.auth.component.BaseSecurityBeanDefinitionRegistrar;
import com.xxxJppp.cloud.auth.config.SecurityHandlerConfig;
import com.xxxJppp.cloud.auth.feign.OAuth2FeignConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author
 * <p>
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({BaseSecurityBeanDefinitionRegistrar.class, OAuth2FeignConfig.class ,SecurityHandlerConfig.class})
public @interface EnableBaseResourceServer {

}
