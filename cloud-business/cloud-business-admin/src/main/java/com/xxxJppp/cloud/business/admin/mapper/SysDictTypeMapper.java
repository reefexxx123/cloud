package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 字典类型
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysDictType
     * @return
     */
    IPage<SysDictType> findListByPage(Page<SysDictType> page, SysDictType sysDictType);
}
