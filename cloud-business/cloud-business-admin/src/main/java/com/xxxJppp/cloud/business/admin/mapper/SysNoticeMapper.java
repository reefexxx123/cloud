package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.SysNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 通知公告
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface SysNoticeMapper extends BaseMapper<SysNotice> {
    /**
     * 分页查询用户列表
     * @param page
     * @param sysNotice
     * @return
     */
    IPage<SysNotice> findListByPage(Page<SysNotice> page, SysNotice sysNotice);
}
