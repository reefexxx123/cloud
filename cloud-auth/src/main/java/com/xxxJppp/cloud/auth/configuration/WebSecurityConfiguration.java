package com.xxxJppp.cloud.auth.configuration;

import com.xxxJppp.cloud.auth.handler.UserAuthenticationProvider;
import com.xxxJppp.cloud.auth.service.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
/**
 * security配置
 * @author xxxJppp
 * @version 1.0
 * @date 2020/6/18
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private IUserDetailsService userDetailsService;
	@Resource
	private UserAuthenticationProvider customAuthenticationProvider;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authentication -> customAuthenticationProvider.authenticate(authentication);
	}
	/**
	 * 验证处理器
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//配置登录user验证处理器。springboot2.0需要配置passwordEncoder，否则报错
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
			.loginPage("/token/login")
			.loginProcessingUrl("/token/form")
			.and()
			.authorizeRequests()
			.antMatchers(
					"/oauth/**",
					"/token/**",
					"/actuator/**",
					"/login**"
					).permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/error",
				"/css/**",
				"/static/**",
				"/v2/api-docs/**",
				"/swagger-resources/**",
				"/webjars/**",
				"/favicon.ico",
				"/doc.html"
		);
	}
}
