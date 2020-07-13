package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysMenu;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 菜单权限Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 分页查询
     * @param page
     * @param sysMenu
     * @return
     */
    PageResult<SysMenu> findListByPage(Page<SysMenu> page, SysMenu sysMenu);
}

