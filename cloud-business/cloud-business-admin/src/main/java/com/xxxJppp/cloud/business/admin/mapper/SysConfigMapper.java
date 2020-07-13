package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 参数配置
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysConfig
     * @return
     */
    IPage<SysConfig> findListByPage(Page<SysConfig> page, SysConfig sysConfig);
}
