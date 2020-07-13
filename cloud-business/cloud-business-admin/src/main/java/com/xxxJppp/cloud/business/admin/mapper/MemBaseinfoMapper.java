package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.MemBaseinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 会员基本信息
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface MemBaseinfoMapper extends BaseMapper<MemBaseinfo> {
    /**
     * 分页查询用户列表
     * @param page
     * @param memBaseinfo
     * @return
     */
    IPage<MemBaseinfo> findListByPage(Page<MemBaseinfo> page, MemBaseinfo memBaseinfo);
}
