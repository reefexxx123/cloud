package com.xxxJppp.cloud.auth.handler;

import com.xxxJppp.cloud.auth.service.IUserDetailsService;
import com.xxxJppp.cloud.common.model.SecurityUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 具体的用户密码验证方法
 *
 * @author xxxJppp
 * @version 1.0
 * @date 2020/6/18
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private IUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        SecurityUser user = (SecurityUser) userDetailsService.loadUserByUsername(username);

        //验证密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (user == null) {
            throw new BadCredentialsException("用户不存在");
        }

        if (password == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }

        //过期状态
        if (!user.isAccountNonExpired()) {
            throw new BadCredentialsException("账户已过期");
        }

        //锁定状态
        if (!user.isAccountNonLocked()) {
            throw new BadCredentialsException("该用户已锁定");
        }

        //禁用状态
        if (!user.isEnabled()) {
            throw new BadCredentialsException("账号已禁用");
        }

        if (!user.isCredentialsNonExpired()) {
            throw new BadCredentialsException("密码已过期");
        }


        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        //这边登录后可以设置各种相关信息，比如登录日志，用户缓存等
        //存储认证信息
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(user, password, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
