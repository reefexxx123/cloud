package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 角色信息
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysRole
     * @return
     */
    IPage<SysRole> findListByPage(Page<SysRole> page, SysRole sysRole);
}
