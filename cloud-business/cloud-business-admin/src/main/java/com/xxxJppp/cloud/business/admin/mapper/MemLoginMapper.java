package com.xxxJppp.cloud.business.admin.mapper;

import com.xxxJppp.cloud.business.admin.model.MemLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


/**
 * 会员登录账号
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Mapper
public interface MemLoginMapper extends BaseMapper<MemLogin> {
    /**
     * 分页查询用户列表
     * @param page
     * @param memLogin
     * @return
     */
    IPage<MemLogin> findListByPage(Page<MemLogin> page, MemLogin memLogin);
}
