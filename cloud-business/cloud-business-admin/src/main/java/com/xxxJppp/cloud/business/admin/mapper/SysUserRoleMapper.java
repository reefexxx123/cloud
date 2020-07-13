package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户和角色关联
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysUserRole
     * @return
     */
    IPage<SysUserRole> findListByPage(Page<SysUserRole> page, SysUserRole sysUserRole);
}
