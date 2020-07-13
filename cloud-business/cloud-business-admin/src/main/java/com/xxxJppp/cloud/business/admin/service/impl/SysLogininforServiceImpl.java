package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysLogininforMapper;
import com.xxxJppp.cloud.business.admin.model.SysLogininfor;
import com.xxxJppp.cloud.business.admin.service.ISysLogininforService;

/**
 * 系统访问记录Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforMapper, SysLogininfor> implements ISysLogininforService {
    /**
    *  分页查询
     * @param page
     * @param sysLogininfor
     * @return
     */
    @Override
    public PageResult<SysLogininfor> findListByPage(Page<SysLogininfor> page, SysLogininfor sysLogininfor){
        IPage<SysLogininfor> iPage  =  baseMapper.findListByPage(page, sysLogininfor);
        return PageResult.succeed(iPage);
    }
}
