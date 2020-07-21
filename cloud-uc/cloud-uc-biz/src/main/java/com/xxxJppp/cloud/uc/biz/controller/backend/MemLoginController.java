package com.xxxJppp.cloud.uc.biz.controller.backend;


import com.xxxJppp.cloud.common.exception.BusinessException;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import com.xxxJppp.cloud.uc.api.domain.MemLoginDTO;
import com.xxxJppp.cloud.uc.api.entity.MemLogin;
import com.xxxJppp.cloud.uc.biz.service.IMemLoginService;
import com.xxxJppp.cloud.uc.biz.service.ISysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理API
 *
 * @author xxxJppp
 * @date 2020/4/30 13:12
 */
@RestController
@RequestMapping("/backend/mem")
@Api(value = "用户管理API", tags = {"用户管理API"})
public class MemLoginController {
    @Autowired
    private IMemLoginService memLoginService;

    @ApiOperation("获取用户信息")
    @GetMapping("/info/{userIdOrUserNameOrMobile}")
    public Result<SecurityUser> getUserInfo(@PathVariable String userIdOrUserNameOrMobile) {
        MemLogin user = memLoginService.findUserByUserIdOrUserNameOrMobile(userIdOrUserNameOrMobile);
        if (user == null) {
            throw new BusinessException("未查询到用户数据");
        }
        return Result.succeed(memLoginService.findUserInfo(user));
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/get/{userId}")
    public Result<MemLoginDTO> getUserInfo(@PathVariable Long userId) {
        return Result.succeed(memLoginService.findUserInfoByUesrId(userId));
    }
}

