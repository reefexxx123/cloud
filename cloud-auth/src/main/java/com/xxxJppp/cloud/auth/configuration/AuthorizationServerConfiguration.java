package com.xxxJppp.cloud.auth.configuration;

import com.xxxJppp.cloud.auth.serializer.BaseWebResponseExceptionTranslator;
import com.xxxJppp.cloud.auth.service.impl.ClientDetailService;
import com.xxxJppp.cloud.auth.service.impl.UserDetailsServiceImpl;
import com.xxxJppp.cloud.common.model.SecurityUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权服务器 主要是配置客户端信息和认证信息
 *
 * @author xxxJppp
 * @date 2020/4/29 20:01
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final TokenStore tokenStore;
    private final DataSource dataSource;
    private final UserDetailsServiceImpl userDetailsService;
    /**
     * 用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
     *
     * @param clients clients
     * @author xxxJppp
     * @date 2020/4/29 20:01
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    /**
     * 声明 ClientDetails实现,不用加@Bean 冲突报错
     */
    public JdbcClientDetailsService clientDetailsService(){
        return new ClientDetailService(dataSource);
    }

    /**
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services),告诉spring security token的生成方式。
     *
     * @param endpoints endpoints
     * @author xxxJppp
     * @date 2020/4/29 20:08
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .tokenEnhancer(tokenEnhancer())
                .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false)
                .pathMapping("/oauth/confirm_access", "/token/confirm_access")
                .exceptionTranslator(new BaseWebResponseExceptionTranslator());
    }

    /**
     * 认证服务器的安全配置
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .checkTokenAccess("permitAll()") //isAuthenticated():排除anonymous   isFullyAuthenticated():排除anonymous以及remember-me
                .allowFormAuthenticationForClients();  //允许表单认证
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(4);
            SecurityUser user = (SecurityUser) authentication.getUserAuthentication().getPrincipal();
            additionalInfo.put("userId", user.getUserId());
            additionalInfo.put("username", user.getUsername());
            additionalInfo.put("accno",user.getAccno());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    public static void main(String[] args) {
        System.out.println(!Boolean.TRUE.equals(true));
    }
}
