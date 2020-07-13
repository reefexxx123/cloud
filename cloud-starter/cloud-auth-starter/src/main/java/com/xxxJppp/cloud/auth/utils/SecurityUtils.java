package com.xxxJppp.cloud.auth.utils;


import cn.hutool.core.util.StrUtil;
import com.xxxJppp.cloud.common.constant.SecurityConstant;
import com.xxxJppp.cloud.common.model.SecurityUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 安全工具类
 *
 * @author
 */
@UtilityClass
public class SecurityUtils {
	/**
	 * 获取Authentication
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 *
	 * @param authentication
	 * @return BaseUser
	 * <p>
	 * 获取当前用户的全部信息 EnableBaseResourceServer true
	 * 获取当前用户的用户名 EnableBaseResourceServer false
	 */
	public SecurityUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof SecurityUser) {
			return (SecurityUser) principal;
		}
		return null;
	}

	/**
	 * 获取用户
	 */
	public SecurityUser getUser() {
		Authentication authentication = getAuthentication();
		return getUser(authentication);
	}

	/**
	 * 获取用户角色信息
	 *
	 * @return 角色集合
	 */
	public List<String> getRoles() {
		Authentication authentication = getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roleIds = new ArrayList<>();
		authorities.stream()
				.filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstant.ROLE))
				.forEach(granted -> {
					String id = StrUtil.removePrefix(granted.getAuthority(), SecurityConstant.ROLE);
					roleIds.add(id);
				});
		return roleIds;
	}

}
