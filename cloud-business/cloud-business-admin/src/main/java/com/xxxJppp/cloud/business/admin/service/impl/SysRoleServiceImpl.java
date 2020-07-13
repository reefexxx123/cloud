package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysRoleMapper;
import com.xxxJppp.cloud.business.admin.model.SysRole;
import com.xxxJppp.cloud.business.admin.service.ISysRoleService;

/**
 * 角色信息Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    /**
    *  分页查询
     * @param page
     * @param sysRole
     * @return
     */
    @Override
    public PageResult<SysRole> findListByPage(Page<SysRole> page, SysRole sysRole){
        IPage<SysRole> iPage  =  baseMapper.findListByPage(page, sysRole);
        return PageResult.succeed(iPage);
    }
}
