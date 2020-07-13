package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysRole;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色信息Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 分页查询
     * @param page
     * @param sysRole
     * @return
     */
    PageResult<SysRole> findListByPage(Page<SysRole> page, SysRole sysRole);
}

