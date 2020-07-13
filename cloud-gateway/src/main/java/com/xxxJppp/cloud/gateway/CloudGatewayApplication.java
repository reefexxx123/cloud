package com.xxxJppp.cloud.gateway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 网关
 *
 * @author xxxJppp
 * @date 2020/6/1 16:05
 */
@EnableEurekaClient
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class CloudGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudGatewayApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

}
