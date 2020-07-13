package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysRoleDept;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色和部门关联Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysRoleDeptService extends IService<SysRoleDept> {
    /**
     * 分页查询
     * @param page
     * @param sysRoleDept
     * @return
     */
    PageResult<SysRoleDept> findListByPage(Page<SysRoleDept> page, SysRoleDept sysRoleDept);
}

