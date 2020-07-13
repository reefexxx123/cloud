package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysConfigMapper;
import com.xxxJppp.cloud.business.admin.model.SysConfig;
import com.xxxJppp.cloud.business.admin.service.ISysConfigService;

/**
 * 参数配置Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {
    /**
    *  分页查询
     * @param page
     * @param sysConfig
     * @return
     */
    @Override
    public PageResult<SysConfig> findListByPage(Page<SysConfig> page, SysConfig sysConfig){
        IPage<SysConfig> iPage  =  baseMapper.findListByPage(page, sysConfig);
        return PageResult.succeed(iPage);
    }
}
