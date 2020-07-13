package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysNotice;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 通知公告Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysNoticeService extends IService<SysNotice> {
    /**
     * 分页查询
     * @param page
     * @param sysNotice
     * @return
     */
    PageResult<SysNotice> findListByPage(Page<SysNotice> page, SysNotice sysNotice);
}

