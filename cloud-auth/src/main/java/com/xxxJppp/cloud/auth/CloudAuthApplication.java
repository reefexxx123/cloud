package com.xxxJppp.cloud.auth;

import com.xxxJppp.cloud.auth.annotation.EnableCloudOauth2Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xxxJppp
 */
@EnableCloudOauth2Server
@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
@EnableFeignClients(basePackages = "com.xxxJppp.cloud.*.api.feign")
@SpringBootApplication()
public class CloudAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAuthApplication.class, args);
    }
}
