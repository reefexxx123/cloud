package com.xxxJppp.cloud.auth.controller;

import com.xxxJppp.cloud.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 瑞夫
 * @version 1.0
 * @Description
 * @date 2020/7/2
 **/
@Api(tags = "测试")
@RestController
@RequestMapping
public class TestController {

    @ApiOperation(value = "测试")
    @GetMapping("test")
    public Result test(){
     return Result.succeed("测试数据");
    }
}
