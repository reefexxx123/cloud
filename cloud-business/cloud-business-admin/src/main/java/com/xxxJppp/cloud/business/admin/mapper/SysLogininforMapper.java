package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysLogininfor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统访问记录
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysLogininforMapper extends BaseMapper<SysLogininfor> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysLogininfor
     * @return
     */
    IPage<SysLogininfor> findListByPage(Page<SysLogininfor> page, SysLogininfor sysLogininfor);
}
