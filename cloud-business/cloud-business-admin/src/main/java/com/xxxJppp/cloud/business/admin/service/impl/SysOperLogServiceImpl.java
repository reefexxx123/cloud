package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysOperLogMapper;
import com.xxxJppp.cloud.business.admin.model.SysOperLog;
import com.xxxJppp.cloud.business.admin.service.ISysOperLogService;

/**
 * 操作日志记录Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {
    /**
    *  分页查询
     * @param page
     * @param sysOperLog
     * @return
     */
    @Override
    public PageResult<SysOperLog> findListByPage(Page<SysOperLog> page, SysOperLog sysOperLog){
        IPage<SysOperLog> iPage  =  baseMapper.findListByPage(page, sysOperLog);
        return PageResult.succeed(iPage);
    }
}
