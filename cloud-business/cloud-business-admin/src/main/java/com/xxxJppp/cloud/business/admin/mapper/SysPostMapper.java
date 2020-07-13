package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 岗位信息
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysPost
     * @return
     */
    IPage<SysPost> findListByPage(Page<SysPost> page, SysPost sysPost);
}
