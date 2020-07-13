package com.xxxJppp.cloud.business.admin.service.impl;

import com.xxxJppp.cloud.common.model.PageResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xxxJppp.cloud.business.admin.mapper.SysMenuMapper;
import com.xxxJppp.cloud.business.admin.model.SysMenu;
import com.xxxJppp.cloud.business.admin.service.ISysMenuService;

/**
 * 菜单权限Service业务层处理
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    /**
    *  分页查询
     * @param page
     * @param sysMenu
     * @return
     */
    @Override
    public PageResult<SysMenu> findListByPage(Page<SysMenu> page, SysMenu sysMenu){
        IPage<SysMenu> iPage  =  baseMapper.findListByPage(page, sysMenu);
        return PageResult.succeed(iPage);
    }
}
