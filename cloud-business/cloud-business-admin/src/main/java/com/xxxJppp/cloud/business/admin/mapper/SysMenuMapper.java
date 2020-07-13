package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 菜单权限
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysMenu
     * @return
     */
    IPage<SysMenu> findListByPage(Page<SysMenu> page, SysMenu sysMenu);
}
