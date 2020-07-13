package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysUserPost;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户与岗位关联Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysUserPostService extends IService<SysUserPost> {
    /**
     * 分页查询
     * @param page
     * @param sysUserPost
     * @return
     */
    PageResult<SysUserPost> findListByPage(Page<SysUserPost> page, SysUserPost sysUserPost);
}

