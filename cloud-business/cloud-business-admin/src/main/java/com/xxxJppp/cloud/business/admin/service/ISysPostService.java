package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysPost;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 岗位信息Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysPostService extends IService<SysPost> {
    /**
     * 分页查询
     * @param page
     * @param sysPost
     * @return
     */
    PageResult<SysPost> findListByPage(Page<SysPost> page, SysPost sysPost);
}

