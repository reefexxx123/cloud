package com.xxxJppp.cloud.uc.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxJppp.cloud.uc.api.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 后台系统角色表 Mapper 接口
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<String> findRolesByUserId(Long userId);

    List<SysRole> selectRolePermissionByUserId(Long userId);

    SysRole isAdminByUserId(Long userId);
}
