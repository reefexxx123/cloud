package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysNoticeMapper;
import com.xxxJppp.cloud.business.admin.model.SysNotice;
import com.xxxJppp.cloud.business.admin.service.ISysNoticeService;

/**
 * 通知公告Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {
    /**
    *  分页查询
     * @param page
     * @param sysNotice
     * @return
     */
    @Override
    public PageResult<SysNotice> findListByPage(Page<SysNotice> page, SysNotice sysNotice){
        IPage<SysNotice> iPage  =  baseMapper.findListByPage(page, sysNotice);
        return PageResult.succeed(iPage);
    }
}
