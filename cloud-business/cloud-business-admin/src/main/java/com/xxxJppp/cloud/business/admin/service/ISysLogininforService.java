package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysLogininfor;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统访问记录Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysLogininforService extends IService<SysLogininfor> {
    /**
     * 分页查询
     * @param page
     * @param sysLogininfor
     * @return
     */
    PageResult<SysLogininfor> findListByPage(Page<SysLogininfor> page, SysLogininfor sysLogininfor);
}

