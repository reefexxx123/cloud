package com.xxxJppp.cloud.uc.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = "com.xxxJppp.cloud.uc.biz.dao")
@EnableFeignClients(basePackages = "com.xxxJppp.cloud.*.api.feign")
@SpringBootApplication
public class UcBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcBizApplication.class, args);
    }

}
