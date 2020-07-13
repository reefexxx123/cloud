package com.xxxJppp.cloud.gateway.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.HashSet;
import java.util.Set;

/**
 * swagger聚合配置
 *
 * @author xxxJppp
 * @date 2020/4/29 22:14
 */
@Data
@RefreshScope
@ConfigurationProperties("cloud.swagger-agg")
public class SwaggerAggProperties {

    private boolean enabled = false;

    /**
     * Swagger返回JSON文档的接口路径（全局配置）
     */
    private String apiDocsPath = "/api-docs";

    /**
     * Swagger文档版本（全局配置）
     */
    private String swaggerVersion = "2.0";

    /**
     * 自动生成文档的路由名称，设置了generateRoutes之后，ignoreRoutes不生效
     */
    private Set<String> generateRoutes = new HashSet<>();

    /**
     * 不自动生成文档的路由名称，设置了generateRoutes之后，本配置不生效
     */
    private Set<String> ignoreRoutes = new HashSet<>();

    /**
     * 是否显示该路由
     */
    public boolean isShow(String route) {
        int generateRoutesSize = generateRoutes.size();
        int ignoreRoutesSize = ignoreRoutes.size();

        if (generateRoutesSize > 0 && !generateRoutes.contains(route)) {
            return false;
        }

        return ignoreRoutesSize <= 0 || !ignoreRoutes.contains(route);
    }
}
