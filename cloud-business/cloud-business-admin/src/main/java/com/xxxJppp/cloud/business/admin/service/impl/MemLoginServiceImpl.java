package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.MemLoginMapper;
import com.xxxJppp.cloud.business.admin.model.MemLogin;
import com.xxxJppp.cloud.business.admin.service.IMemLoginService;

/**
 * 会员登录账号Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class MemLoginServiceImpl extends ServiceImpl<MemLoginMapper, MemLogin> implements IMemLoginService {
    /**
    *  分页查询
     * @param page
     * @param memLogin
     * @return
     */
    @Override
    public PageResult<MemLogin> findListByPage(Page<MemLogin> page, MemLogin memLogin){
        IPage<MemLogin> iPage  =  baseMapper.findListByPage(page, memLogin);
        return PageResult.succeed(iPage);
    }
}
