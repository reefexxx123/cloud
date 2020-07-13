package com.xxxJppp.cloud.auth.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xxxJppp.cloud.auth.service.IUserDetailsService;
import com.xxxJppp.cloud.common.enums.LoginTypeEnum;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import com.xxxJppp.cloud.uc.api.feign.RemoteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * UserServiceDetail
 *
 * @author xxxJppp
 * @date 2020/4/29 17:46
 */
@Slf4j
public class UserDetailsServiceImpl implements IUserDetailsService {

    @Resource
    private RemoteUserService remoteUserService;

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     */
    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<SecurityUser> info = remoteUserService.getUserInfoByUsername(username);

        if (ObjectUtil.isNull(info) || info.getCode() == HttpStatus.NOT_FOUND.value()) {
            log.debug("登录用户：" + username + " 不存在.");
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        return info.getData();
    }

    /**
     * 手机验证码登录
     *
     * @param mobile 手机号码
     */
    @Override
    public SecurityUser loadUserByMobile(String mobile) throws UsernameNotFoundException {
        //  通过手机号mobile去数据库里查找用户以及用户权限
        Result<SecurityUser> info = remoteUserService.getUserInfoByMobile(mobile);
        if (ObjectUtil.isNull(info) || info.getCode() == HttpStatus.NOT_FOUND.value()) {
            log.info("登录手机号：" + mobile + " 不存在.");
            throw new UsernameNotFoundException("登录手机号：" + mobile + " 不存在");
        }
        return info.getData();
    }

    @Override
    public SecurityUser loadUserByOpenId(String openId) {
        // todo 这里要实现
        return null;
    }

    @Override
    public SecurityUser loadThirdUser(String code, LoginTypeEnum loginTypeEnum) {
        // todo 这里要实现
        return null;
    }
}

