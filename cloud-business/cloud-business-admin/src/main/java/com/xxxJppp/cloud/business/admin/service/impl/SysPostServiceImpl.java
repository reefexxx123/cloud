package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysPostMapper;
import com.xxxJppp.cloud.business.admin.model.SysPost;
import com.xxxJppp.cloud.business.admin.service.ISysPostService;

/**
 * 岗位信息Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {
    /**
    *  分页查询
     * @param page
     * @param sysPost
     * @return
     */
    @Override
    public PageResult<SysPost> findListByPage(Page<SysPost> page, SysPost sysPost){
        IPage<SysPost> iPage  =  baseMapper.findListByPage(page, sysPost);
        return PageResult.succeed(iPage);
    }
}
