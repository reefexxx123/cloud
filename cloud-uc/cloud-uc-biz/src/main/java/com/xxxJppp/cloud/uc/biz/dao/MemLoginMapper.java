package com.xxxJppp.cloud.uc.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxJppp.cloud.uc.api.domain.MemLoginDTO;
import com.xxxJppp.cloud.uc.api.entity.MemLogin;

/**
 * <p>
 * 会员登录账号 Mapper 接口
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface MemLoginMapper extends BaseMapper<MemLogin> {

    MemLoginDTO getUserByUserName(Long id);
}
