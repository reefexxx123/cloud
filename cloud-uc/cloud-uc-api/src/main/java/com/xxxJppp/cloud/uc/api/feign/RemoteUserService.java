package com.xxxJppp.cloud.uc.api.feign;

import com.xxxJppp.cloud.uc.api.feign.fallback.RemoteUserFallbackImpl;
import com.xxxJppp.cloud.common.constant.ServiceNameConstant;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用用户模块
 *
 * @author xxxJppp
 * @date 2020/5/2 16:42
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstant.CLOUD_UC_CENTER, fallbackFactory = RemoteUserFallbackImpl.class)
public interface RemoteUserService {

    /**
     * 通过用户名查询用户包括角色权限等
     *
     * @param username 用户名
     */
    @GetMapping("/backend/mem/info/{username}")
    Result<SecurityUser> getUserInfoByUsername(@PathVariable("username") String username);

    /**
     * 通过手机号码查询用户包括角色权限等
     *
     * @param mobile 手机号码
     */
    @GetMapping("/backend/mem/info/{mobile}")
    Result<SecurityUser> getUserInfoByMobile(@PathVariable("mobile") String mobile);

    /**
     * 通过第三方查询用户包括角色权限等
     *
     * @param providerId     providerId
     * @param providerUserId providerUserId
     */
    @GetMapping("/backend/user/mem/social")
    Result<SecurityUser> getUserInfoBySocial(@RequestParam("providerId") String providerId,
                                             @RequestParam("providerUserId") int providerUserId);

}

