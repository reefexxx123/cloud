package com.xxxJppp.cloud.uc.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxJppp.cloud.common.model.SecurityUser;
import com.xxxJppp.cloud.uc.api.entity.MemLogin;

import java.util.Set;

/**
 * <p>
 * 会员登录账号 服务类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface IMemLoginService extends IService<MemLogin> {

    MemLogin findByUserName(String username);

    MemLogin findUserByUserIdOrUserNameOrMobile(String userIdOrUserNameOrMobileOrEmail);

    SecurityUser findUserInfo(MemLogin user);

}
