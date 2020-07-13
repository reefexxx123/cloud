package com.xxxJppp.cloud.business.admin;

import com.xxxJppp.cloud.auth.annotation.EnableBaseFeignClients;
import com.xxxJppp.cloud.auth.annotation.EnableBaseResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author 瑞夫
 * @version 1.0
 * @Description
 * @date 2020/6/30
 **/
@EnableBaseFeignClients
@EnableBaseResourceServer
@EnableEurekaClient
@SpringBootApplication
public class BusinessAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessAdminApplication.class);
    }

}
