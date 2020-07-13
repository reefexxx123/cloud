package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.SysDictData;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 字典数据Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface ISysDictDataService extends IService<SysDictData> {
    /**
     * 分页查询
     * @param page
     * @param sysDictData
     * @return
     */
    PageResult<SysDictData> findListByPage(Page<SysDictData> page, SysDictData sysDictData);
}

