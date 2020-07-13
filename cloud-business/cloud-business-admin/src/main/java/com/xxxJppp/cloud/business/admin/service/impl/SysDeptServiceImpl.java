package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysDeptMapper;
import com.xxxJppp.cloud.business.admin.model.SysDept;
import com.xxxJppp.cloud.business.admin.service.ISysDeptService;

/**
 * 部门Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
    /**
    *  分页查询
     * @param page
     * @param sysDept
     * @return
     */
    @Override
    public PageResult<SysDept> findListByPage(Page<SysDept> page, SysDept sysDept){
        IPage<SysDept> iPage  =  baseMapper.findListByPage(page, sysDept);
        return PageResult.succeed(iPage);
    }
}
