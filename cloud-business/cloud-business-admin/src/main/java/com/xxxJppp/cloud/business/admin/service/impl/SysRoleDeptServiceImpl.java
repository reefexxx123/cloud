package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysRoleDeptMapper;
import com.xxxJppp.cloud.business.admin.model.SysRoleDept;
import com.xxxJppp.cloud.business.admin.service.ISysRoleDeptService;

/**
 * 角色和部门关联Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements ISysRoleDeptService {
    /**
    *  分页查询
     * @param page
     * @param sysRoleDept
     * @return
     */
    @Override
    public PageResult<SysRoleDept> findListByPage(Page<SysRoleDept> page, SysRoleDept sysRoleDept){
        IPage<SysRoleDept> iPage  =  baseMapper.findListByPage(page, sysRoleDept);
        return PageResult.succeed(iPage);
    }
}
