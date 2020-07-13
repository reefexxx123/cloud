package com.xxxJppp.cloud.gateway.handler;

import cn.hutool.core.collection.CollectionUtil;
import com.xxxJppp.cloud.common.constant.SecurityConstant;
import com.xxxJppp.cloud.common.model.SecurityUser;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 认证成功处理类
 *
 * @author xxxJppp
 * @date 2020/4/29 22:10
 */

public class Oauth2AuthSuccessHandler implements ServerAuthenticationSuccessHandler {

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        MultiValueMap<String, String> headerValues = new LinkedMultiValueMap(4);
        Object principal = authentication.getPrincipal();

        //客户端模式只返回一个clientId
        if (principal instanceof SecurityUser) {
            SecurityUser user = (SecurityUser) authentication.getPrincipal();
            headerValues.add(SecurityConstant.USER_ID_HEADER, String.valueOf(user.getUserId()));
            headerValues.add(SecurityConstant.USER_HEADER, user.getUsername());
        }

        OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;
        String clientId = oauth2Authentication.getOAuth2Request().getClientId();
        headerValues.add(SecurityConstant.TENANT_HEADER, clientId);
        headerValues.add(SecurityConstant.ROLE_HEADER, CollectionUtil.join(authentication.getAuthorities(), ","));

        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate()
                .headers(h -> h.addAll(headerValues))
                .build();

        ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
        return webFilterExchange.getChain().filter(build);
    }
}
