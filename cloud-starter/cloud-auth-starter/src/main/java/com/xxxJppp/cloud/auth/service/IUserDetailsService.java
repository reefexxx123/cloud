package com.xxxJppp.cloud.auth.service;

import com.xxxJppp.cloud.common.enums.LoginTypeEnum;
import com.xxxJppp.cloud.common.model.SecurityUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * IUserDetailsService
 *
 * @author xxxJppp
 * @date 2020/4/29 17:33
 */
public interface IUserDetailsService extends UserDetailsService {

    /**
     * 根据电话号码查询用户
     *
     * @param mobile 手机号码
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author xxxJppp
     * @date 2020/4/29 22:02
     */
    SecurityUser loadUserByMobile(String mobile);

    /**
     * 根据openId查询用户
     *
     * @param openId openId
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author xxxJppp
     * @date 2020/4/29 22:02
     */
    SecurityUser loadUserByOpenId(String openId);

    /**
     * 获取用户
     *
     * @param para          para
     * @param loginTypeEnum loginType
     * @return com.taotao.cloud.auth.model.SecurityUser
     * @author xxxJppp
     * @date 2020/4/29 21:25
     */
    SecurityUser loadThirdUser(String para, LoginTypeEnum loginTypeEnum);
}
