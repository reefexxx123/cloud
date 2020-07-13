package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysDictTypeMapper;
import com.xxxJppp.cloud.business.admin.model.SysDictType;
import com.xxxJppp.cloud.business.admin.service.ISysDictTypeService;

/**
 * 字典类型Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {
    /**
    *  分页查询
     * @param page
     * @param sysDictType
     * @return
     */
    @Override
    public PageResult<SysDictType> findListByPage(Page<SysDictType> page, SysDictType sysDictType){
        IPage<SysDictType> iPage  =  baseMapper.findListByPage(page, sysDictType);
        return PageResult.succeed(iPage);
    }
}
