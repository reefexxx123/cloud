package com.xxxJppp.cloud.uc.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxJppp.cloud.common.utils.StringUtils;
import com.xxxJppp.cloud.uc.biz.dao.SysRoleMapper;
import com.xxxJppp.cloud.uc.api.entity.SysRole;
import com.xxxJppp.cloud.uc.biz.service.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 后台系统角色表 服务实现类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<String> findRolesByUserId(Long userId) {
        return sysRoleMapper.findRolesByUserId(userId);
    }


    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> perms = sysRoleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public boolean isAdmin(Long userId) {
        SysRole sysRole = baseMapper.isAdminByUserId(userId);
        if (sysRole != null) return true;
        else return false;
    }
}
