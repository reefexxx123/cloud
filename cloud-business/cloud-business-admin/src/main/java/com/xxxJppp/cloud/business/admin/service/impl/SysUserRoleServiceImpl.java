package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysUserRoleMapper;
import com.xxxJppp.cloud.business.admin.model.SysUserRole;
import com.xxxJppp.cloud.business.admin.service.ISysUserRoleService;

/**
 * 用户和角色关联Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    /**
    *  分页查询
     * @param page
     * @param sysUserRole
     * @return
     */
    @Override
    public PageResult<SysUserRole> findListByPage(Page<SysUserRole> page, SysUserRole sysUserRole){
        IPage<SysUserRole> iPage  =  baseMapper.findListByPage(page, sysUserRole);
        return PageResult.succeed(iPage);
    }
}
