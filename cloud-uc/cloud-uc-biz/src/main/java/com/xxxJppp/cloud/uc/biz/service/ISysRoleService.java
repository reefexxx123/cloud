package com.xxxJppp.cloud.uc.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxJppp.cloud.uc.api.entity.SysRole;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 后台系统角色表 服务类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface ISysRoleService extends IService<SysRole> {

    List<String> findRolesByUserId(Long userId);

    Set<String> selectRolePermissionByUserId(Long userId);

    boolean isAdmin(Long userId);
}
