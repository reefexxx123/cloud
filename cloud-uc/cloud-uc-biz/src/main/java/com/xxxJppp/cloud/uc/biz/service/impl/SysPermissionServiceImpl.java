package com.xxxJppp.cloud.uc.biz.service.impl;

import com.xxxJppp.cloud.uc.biz.service.ISysMenuService;
import com.xxxJppp.cloud.uc.biz.service.ISysPermissionService;
import com.xxxJppp.cloud.uc.biz.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 后台系统权限 服务实现类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;


    /**
     * 获取角色数据权限
     *
     * @param userId 用户Id
     * @return 角色权限信息
     */
    @Override
    public Set<String> getRolePermission(Long userId) {
        Set<String> roles = new HashSet<>();
        // 管理员拥有所有权限
        boolean isAdmin = roleService.isAdmin(userId);
        if (isAdmin) {
            roles.add("admin");
        }else {
            roles.addAll(roleService.selectRolePermissionByUserId(userId));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     *
     * @param userId 用户Id
     * @return 菜单权限信息
     */
    @Override
    public Set<String> getMenuPermission(Long userId) {
        Set<String> perms = new HashSet<>();
        // 管理员拥有所有权限
        boolean isAdmin = roleService.isAdmin(userId);
        if (isAdmin) {
            perms.add("*:*:*");
        } else {
            perms.addAll(menuService.selectMenuPermsByUserId(userId));
        }
        return perms;
    }
}
