package com.xxxJppp.cloud.uc.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxJppp.cloud.common.model.SecurityUser;
import com.xxxJppp.cloud.uc.api.domain.MemLoginDTO;
import com.xxxJppp.cloud.uc.biz.dao.MemLoginMapper;
import com.xxxJppp.cloud.uc.api.entity.MemLogin;
import com.xxxJppp.cloud.uc.biz.service.IMemLoginService;
import com.xxxJppp.cloud.uc.biz.service.ISysMenuService;
import com.xxxJppp.cloud.uc.biz.service.ISysPermissionService;
import com.xxxJppp.cloud.uc.biz.service.ISysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 会员登录账号 服务实现类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
@Service
public class MemLoginServiceImpl extends ServiceImpl<MemLoginMapper, MemLogin> implements IMemLoginService {
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysPermissionService permissionService;

    @Override
    public MemLogin findByUserName(String username) {
        LambdaQueryWrapper<MemLogin> select = Wrappers.<MemLogin>lambdaQuery();
        select.eq(MemLogin::getLoginname,username);
        return getOne(select);
    }

    @Override
    public MemLogin findUserByUserIdOrUserNameOrMobile(String userIdOrUserNameOrMobileOrEmail) {
        LambdaQueryWrapper<MemLogin> select = Wrappers.<MemLogin>lambdaQuery()
                .eq(MemLogin::getLoginname, userIdOrUserNameOrMobileOrEmail)
                .or()
                .eq(MemLogin::getId, userIdOrUserNameOrMobileOrEmail);
        return baseMapper.selectOne(select);
    }

    @Override
    public SecurityUser findUserInfo(MemLogin user) {
        boolean isAdmin = roleService.isAdmin(user.getId());
        // 权限集合
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user.getId());
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user.getId());
        SecurityUser securityUser = new SecurityUser(user.getId(), user.getLoginname(),
                user.getPassword(), permissions, roles);

        BeanUtil.copyProperties(user, securityUser);
        securityUser.setAccno(user.getAccno());
        securityUser.setAdmin(isAdmin);
        return securityUser;
    }

    @Override
    public MemLoginDTO findUserInfoByUesrId(Long userId) {
        return baseMapper.getUserByUserName(userId);
    }
}
