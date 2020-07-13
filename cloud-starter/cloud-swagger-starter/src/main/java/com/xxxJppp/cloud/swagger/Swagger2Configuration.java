package com.xxxJppp.cloud.swagger;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * Swagger2Configuration
 *
 * @author xxxJppp
 * @date 2020/4/30 10:09
 */
@ConditionalOnProperty(name = "cloud.swagger.enabled")
@Import({Swagger2DocumentationConfiguration.class})
public class Swagger2Configuration {

}
