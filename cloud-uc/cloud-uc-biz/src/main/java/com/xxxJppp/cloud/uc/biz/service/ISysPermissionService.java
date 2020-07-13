package com.xxxJppp.cloud.uc.biz.service;

import java.util.Set;

/**
 * <p>
 * 后台系统权限 服务类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface ISysPermissionService {

    Set<String> getRolePermission(Long userId);

    Set<String> getMenuPermission(Long userId);
}
