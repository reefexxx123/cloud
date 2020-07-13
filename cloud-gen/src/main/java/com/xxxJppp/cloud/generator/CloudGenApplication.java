package com.xxxJppp.cloud.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.xxxJppp.cloud.*.mapper")
public class CloudGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudGenApplication.class, args);
    }
}
