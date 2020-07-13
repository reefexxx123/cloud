package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.MemBaseinfo;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 会员基本信息Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface IMemBaseinfoService extends IService<MemBaseinfo> {
    /**
     * 分页查询
     * @param page
     * @param memBaseinfo
     * @return
     */
    PageResult<MemBaseinfo> findListByPage(Page<MemBaseinfo> page, MemBaseinfo memBaseinfo);
}

