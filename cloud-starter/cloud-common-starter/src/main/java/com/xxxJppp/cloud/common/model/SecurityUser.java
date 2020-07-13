package com.xxxJppp.cloud.common.model;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户手机号和账号密码 身份权限认证类 登陆身份认证
 *
 * @author xxxJppp
 * @date 2020/4/29 17:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SecurityUser implements UserDetails, Serializable {

    private static final long serialVersionUID = -3685249101751401211L;
    private static final String ROLE_PREFIX = "ROLE_";

    private Long userId;
    private String username;
    private String password;
    private String accno;
    private String deptId;
    private String jobId;
    private String email;
    private String mobile;
    private String avatar;
    private String lockFlag;
    private String delFlag;
    private String nickname;
    private Integer sex;
    private String type;

    private Set<String> permissions;
    private Set<String> roles;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;


    /**
     * @param userId      用户Id
     * @param username    用户名称
     * @param password    密码
     * @param permissions 权限
     * @param roles       权限
     */
    public SecurityUser(Long userId,
                        String username,
                        String password,
                        Set<String> permissions,
                        Set<String> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.roles = roles;

        this.authorities = getAuthorities();
    }


    /**
     * @param userId
     * @param username
     * @param authorities
     */
    public SecurityUser(Long userId,
                        String username,
                        Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;

        this.authorities = authorities;
    }


    /***
     * 权限重写
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(this.roles)) {
            this.roles.parallelStream().forEach(role -> collection.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
        }
        if (!CollectionUtils.isEmpty(this.permissions)) {
            this.permissions.parallelStream().forEach(permission -> collection.add(new SimpleGrantedAuthority(permission)));
        }
        return collection;
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
