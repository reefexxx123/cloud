package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysDictDataMapper;
import com.xxxJppp.cloud.business.admin.model.SysDictData;
import com.xxxJppp.cloud.business.admin.service.ISysDictDataService;

/**
 * 字典数据Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {
    /**
    *  分页查询
     * @param page
     * @param sysDictData
     * @return
     */
    @Override
    public PageResult<SysDictData> findListByPage(Page<SysDictData> page, SysDictData sysDictData){
        IPage<SysDictData> iPage  =  baseMapper.findListByPage(page, sysDictData);
        return PageResult.succeed(iPage);
    }
}
