package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysRoleMenuMapper;
import com.xxxJppp.cloud.business.admin.model.SysRoleMenu;
import com.xxxJppp.cloud.business.admin.service.ISysRoleMenuService;

/**
 * 角色和菜单关联Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
    /**
    *  分页查询
     * @param page
     * @param sysRoleMenu
     * @return
     */
    @Override
    public PageResult<SysRoleMenu> findListByPage(Page<SysRoleMenu> page, SysRoleMenu sysRoleMenu){
        IPage<SysRoleMenu> iPage  =  baseMapper.findListByPage(page, sysRoleMenu);
        return PageResult.succeed(iPage);
    }
}
