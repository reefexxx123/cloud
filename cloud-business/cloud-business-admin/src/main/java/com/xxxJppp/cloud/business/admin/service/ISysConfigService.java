package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysConfig;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 参数配置Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysConfigService extends IService<SysConfig> {
    /**
     * 分页查询
     * @param page
     * @param sysConfig
     * @return
     */
    PageResult<SysConfig> findListByPage(Page<SysConfig> page, SysConfig sysConfig);
}

