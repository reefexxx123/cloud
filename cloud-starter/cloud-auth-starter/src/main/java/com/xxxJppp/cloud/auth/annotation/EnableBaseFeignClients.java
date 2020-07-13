package com.xxxJppp.cloud.auth.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * 自定义feign注解
 * 添加basePackages路径
 *
 * @author ruoyi
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableBaseFeignClients {
    String[] value() default {};

    String[] basePackages() default {"com.xxxJppp.cloud.*.api.feign"};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
