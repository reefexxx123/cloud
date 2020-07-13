package com.xxxJppp.cloud.auth.config;

import com.xxxJppp.cloud.auth.component.BaseRemoteTokenServices;
import com.xxxJppp.cloud.auth.component.CustomAuthenticationEntryPoint;
import com.xxxJppp.cloud.auth.properties.SecurityProperties;
import com.xxxJppp.cloud.auth.serializer.BaseWebResponseExceptionTranslator;
import com.xxxJppp.cloud.common.constant.StarterNameConstant;
import com.xxxJppp.cloud.common.utils.ResponseUtil;
import com.xxxJppp.cloud.uc.api.feign.RemoteUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * <p>
 * 1. 支持remoteTokenServices 负载均衡
 * 2. 支持 获取用户全部信息
 */
@Order(6)
@Slf4j
public class BaseResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
	@Resource
	protected CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	@Resource
	private ResourceServerProperties resourceServerProperties;
	@Resource
	private SecurityProperties securityProperties;
	@Resource
	private TokenStore tokenStore;
	@Resource
	private OAuth2WebSecurityExpressionHandler expressionHandler;
	@Resource
	private RemoteUserService remoteUserService;
	@Autowired
	private RestTemplate lbRestTemplate;

	public BaseResourceServerConfigurerAdapter() {
		log.info("[CLOUD][" + StarterNameConstant.CLOUD_AUTH_STARTER + "]" + "资源服务器已启动");
	}

	/**
	 * 默认的配置，对外暴露
	 *
	 * @param http
	 */
	@Override
	@SneakyThrows
	public void configure(HttpSecurity http) {
		/*ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = setHttp(http)
			.authorizeRequests();
		registry.antMatchers(securityProperties.getIgnore().getUrls()).permitAll();
		registry.anyRequest().authenticated();*/

		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl = setHttp(http)
				.authorizeRequests()
				.requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
				.antMatchers(securityProperties.getIgnore().getUrls()).permitAll()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.anyRequest();
		setAuthenticate(authorizedUrl);


		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.and()
				.httpBasic().disable()
				.headers()
				.frameOptions().disable()
				.and()
				.csrf().disable();

	}


	@Bean
	@Primary
	public BaseRemoteTokenServices tokenServices() {
		BaseRemoteTokenServices remoteTokenServices = new BaseRemoteTokenServices();
		DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
		UserAuthenticationConverter userTokenConverter = new CustomUserAuthenticationConverter(remoteUserService);
		accessTokenConverter.setUserTokenConverter(userTokenConverter);
		remoteTokenServices.setCheckTokenEndpointUrl(resourceServerProperties.getTokenInfoUri());
		remoteTokenServices.setClientId(resourceServerProperties.getClientId());
		remoteTokenServices.setClientSecret(resourceServerProperties.getClientSecret());
		remoteTokenServices.setRestTemplate(lbRestTemplate);
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);
		return remoteTokenServices;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.authenticationEntryPoint(customAuthenticationEntryPoint)
				.tokenStore(tokenStore)
				.tokenServices(tokenServices())
				.stateless(true)
				.expressionHandler(expressionHandler)
				.accessDeniedHandler(new OAuth2AccessDeniedHandler() {
					@Override
					public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
						ResponseUtil.failed(response, "无效的token拒绝访问");
					}
				});

		AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
		((OAuth2AuthenticationEntryPoint) authenticationEntryPoint).setExceptionTranslator(new BaseWebResponseExceptionTranslator());
		resources.authenticationEntryPoint(authenticationEntryPoint);
	}

	/**
	 * 留给子类重写扩展功能
	 *
	 * @param http http
	 */
	public HttpSecurity setHttp(HttpSecurity http) {
		return http;
	}

	/**
	 * url权限控制，默认是认证就通过，可以重写实现个性化
	 *
	 * @param authorizedUrl authorizedUrl
	 */
	public HttpSecurity setAuthenticate(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl) {
		return authorizedUrl.authenticated().and();
	}
}
