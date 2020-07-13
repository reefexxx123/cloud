package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.MemBaseinfoMapper;
import com.xxxJppp.cloud.business.admin.model.MemBaseinfo;
import com.xxxJppp.cloud.business.admin.service.IMemBaseinfoService;

/**
 * 会员基本信息Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class MemBaseinfoServiceImpl extends ServiceImpl<MemBaseinfoMapper, MemBaseinfo> implements IMemBaseinfoService {
    /**
    *  分页查询
     * @param page
     * @param memBaseinfo
     * @return
     */
    @Override
    public PageResult<MemBaseinfo> findListByPage(Page<MemBaseinfo> page, MemBaseinfo memBaseinfo){
        IPage<MemBaseinfo> iPage  =  baseMapper.findListByPage(page, memBaseinfo);
        return PageResult.succeed(iPage);
    }
}
