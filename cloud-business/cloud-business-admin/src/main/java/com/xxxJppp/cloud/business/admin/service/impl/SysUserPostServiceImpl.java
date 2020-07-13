package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysUserPostMapper;
import com.xxxJppp.cloud.business.admin.model.SysUserPost;
import com.xxxJppp.cloud.business.admin.service.ISysUserPostService;

/**
 * 用户与岗位关联Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements ISysUserPostService {
    /**
    *  分页查询
     * @param page
     * @param sysUserPost
     * @return
     */
    @Override
    public PageResult<SysUserPost> findListByPage(Page<SysUserPost> page, SysUserPost sysUserPost){
        IPage<SysUserPost> iPage  =  baseMapper.findListByPage(page, sysUserPost);
        return PageResult.succeed(iPage);
    }
}
