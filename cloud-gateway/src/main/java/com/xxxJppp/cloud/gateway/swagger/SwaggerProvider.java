package com.xxxJppp.cloud.gateway.swagger;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SwaggerProvider
 *
 * @author xxxJppp
 * @date 2020/4/29 22:14
 */
@Primary
@ConditionalOnProperty(prefix = "cloud.swagger-agg", name = "enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerProvider implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;
    private final SwaggerAggProperties swaggerAggProperties;

    public SwaggerProvider(RouteLocator routeLocator,
                           GatewayProperties gatewayProperties,
                           SwaggerAggProperties swaggerAggProperties) {
        this.routeLocator = routeLocator;
        this.gatewayProperties = gatewayProperties;
        this.swaggerAggProperties = swaggerAggProperties;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        Set<String> routes = new HashSet<>();
        //取出Spring Cloud Gateway中的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        //结合application.yml中的路由配置，只获取有效的route节点
        gatewayProperties.getRoutes().stream().filter(
                routeDefinition -> (
                        routes.contains(routeDefinition.getId()) && swaggerAggProperties.isShow(routeDefinition.getId())
                )
        ).forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                .forEach(predicateDefinition -> resources.add(
                        swaggerResource(
                                routeDefinition.getId(),
                                predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0").replace("/**", swaggerAggProperties.getApiDocsPath())
                        )
                        )
                )
        );
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(swaggerAggProperties.getSwaggerVersion());
        return swaggerResource;
    }
}
