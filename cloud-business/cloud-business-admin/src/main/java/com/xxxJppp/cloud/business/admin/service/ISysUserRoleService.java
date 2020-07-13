package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysUserRole;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户和角色关联Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysUserRoleService extends IService<SysUserRole> {
    /**
     * 分页查询
     * @param page
     * @param sysUserRole
     * @return
     */
    PageResult<SysUserRole> findListByPage(Page<SysUserRole> page, SysUserRole sysUserRole);
}

