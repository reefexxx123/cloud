package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 操作日志记录
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysOperLog
     * @return
     */
    IPage<SysOperLog> findListByPage(Page<SysOperLog> page, SysOperLog sysOperLog);
}
