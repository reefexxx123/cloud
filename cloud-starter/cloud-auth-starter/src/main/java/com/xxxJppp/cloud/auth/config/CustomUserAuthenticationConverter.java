package com.xxxJppp.cloud.auth.config;

import cn.hutool.core.util.ObjectUtil;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import com.xxxJppp.cloud.uc.api.feign.RemoteUserService;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 根据checktoken 的结果转化用户信息
 *
 * @author xxxJppp
 * @date 2020/5/3 07:47
 */
@AllArgsConstructor
public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {
    private static final String N_A = "N/A";
    private RemoteUserService remoteUserService;

    /**
     * Optional {@link UserDetailsService} to use when extracting an {@link Authentication} from the incoming map.
     *
     * @param remoteUserService the userDetailsService to set
     */
    public void setUserDetailsService(RemoteUserService remoteUserService) {
        this.remoteUserService = remoteUserService;
    }

    /**
     * Extract information about the user to be used in an access token (i.e. for resource servers).
     *
     * @param authentication an authentication representing a user
     * @return a map of key values representing the unique information about the user
     */
    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(USERNAME, authentication.getName());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }
        return response;
    }

    /**
     * Inverse of {@link #convertUserAuthentication(Authentication)}. Extracts an Authentication from a map.
     *
     * @param map a map of user information
     * @return an Authentication representing the user or null if there is none
     */
    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(USERNAME)) {
            Object principal = map.get(USERNAME);
            Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
            if (remoteUserService != null) {
                String username = (String) map.get(USERNAME);
                Result<SecurityUser> info = remoteUserService.getUserInfoByUsername(username);
                if (ObjectUtil.isNull(info) || info.getCode() == HttpStatus.NOT_FOUND.value()) {
                    throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
                }
                principal = info.getData();
            }
            return new UsernamePasswordAuthenticationToken(principal, N_A, authorities);
        }
        return null;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
        Object authorities = map.get(AUTHORITIES);
        if (authorities instanceof String) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
        }
        if (authorities instanceof Collection) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                    .collectionToCommaDelimitedString((Collection<?>) authorities));
        }
        throw new IllegalArgumentException("Authorities must be either a String or a Collection");
    }
}
