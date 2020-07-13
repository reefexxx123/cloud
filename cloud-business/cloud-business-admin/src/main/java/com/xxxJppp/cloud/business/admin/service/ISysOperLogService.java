package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysOperLog;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 操作日志记录Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysOperLogService extends IService<SysOperLog> {
    /**
     * 分页查询
     * @param page
     * @param sysOperLog
     * @return
     */
    PageResult<SysOperLog> findListByPage(Page<SysOperLog> page, SysOperLog sysOperLog);
}

