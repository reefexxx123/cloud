package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 字典数据
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysDictDataMapper extends BaseMapper<SysDictData> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysDictData
     * @return
     */
    IPage<SysDictData> findListByPage(Page<SysDictData> page, SysDictData sysDictData);
}
