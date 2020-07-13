package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysDept;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 部门Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysDeptService extends IService<SysDept> {
    /**
     * 分页查询
     * @param page
     * @param sysDept
     * @return
     */
    PageResult<SysDept> findListByPage(Page<SysDept> page, SysDept sysDept);
}

