package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysUserPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户与岗位关联
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysUserPostMapper extends BaseMapper<SysUserPost> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysUserPost
     * @return
     */
    IPage<SysUserPost> findListByPage(Page<SysUserPost> page, SysUserPost sysUserPost);
}
