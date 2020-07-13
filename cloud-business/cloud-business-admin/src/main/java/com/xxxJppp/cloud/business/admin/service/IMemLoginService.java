package com.xxxJppp.cloud.business.admin.service;

import com.xxxJppp.cloud.business.admin.model.MemLogin;
import com.xxxJppp.cloud.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 会员登录账号Service
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
public interface IMemLoginService extends IService<MemLogin> {
    /**
     * 分页查询
     * @param page
     * @param memLogin
     * @return
     */
    PageResult<MemLogin> findListByPage(Page<MemLogin> page, MemLogin memLogin);
}

