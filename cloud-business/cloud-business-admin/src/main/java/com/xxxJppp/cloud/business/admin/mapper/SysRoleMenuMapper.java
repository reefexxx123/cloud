package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 角色和菜单关联
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysRoleMenu
     * @return
     */
    IPage<SysRoleMenu> findListByPage(Page<SysRoleMenu> page, SysRoleMenu sysRoleMenu);
}
