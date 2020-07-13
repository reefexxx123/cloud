package com.xxxJppp.cloud.business.admin.controller;

import com.xxxJppp.cloud.auth.utils.SecurityUtils;
import com.xxxJppp.cloud.business.admin.service.IMemLoginService;
import com.xxxJppp.cloud.common.base.BaseController;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 瑞夫
 * @version 1.0
 * @Description
 * @date 2020/7/6
 **/
@Slf4j
@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private IMemLoginService memLoginService;

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @ApiOperation(value = "查询当前用户信息")
    @GetMapping("info")
    public Result getInfo() {
        SecurityUser user = SecurityUtils.getUser();
        Long userId = user.getUserId();
        // 角色集合
        Set<String> roles = user.getRoles();
        // 权限集合
        Set<String> permissions = user.getPermissions();
        Map map = new HashMap();
        map.put("user", memLoginService.getById(userId));
        map.put("roles", roles);
        map.put("permissions", permissions);
        return Result.succeed(map);
    }

}
