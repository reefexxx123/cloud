package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 部门
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysDept
     * @return
     */
    IPage<SysDept> findListByPage(Page<SysDept> page, SysDept sysDept);
}
