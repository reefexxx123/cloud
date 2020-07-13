package com.xxxJppp.cloud.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author 瑞夫
 * @version 1.0
 * @Description
 * @date 2020/6/20
 **/
@Api(tags = "用户")
@RestController
@RequestMapping("/oauth")
public class UserController {

    @ApiOperation(value = "当前用户")
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
