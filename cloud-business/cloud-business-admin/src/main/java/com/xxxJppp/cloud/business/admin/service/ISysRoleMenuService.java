package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysRoleMenu;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色和菜单关联Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 分页查询
     * @param page
     * @param sysRoleMenu
     * @return
     */
    PageResult<SysRoleMenu> findListByPage(Page<SysRoleMenu> page, SysRoleMenu sysRoleMenu);
}

