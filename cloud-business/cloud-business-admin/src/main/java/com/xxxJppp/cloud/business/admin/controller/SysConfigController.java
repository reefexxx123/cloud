package com.xxxJppp.cloud.business.admin.controller;
import com.xxxJppp.cloud.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.xxxJppp.cloud.business.admin.model.SysConfig;
import com.xxxJppp.cloud.business.admin.service.ISysConfigService;
import com.xxxJppp.cloud.common.model.PageResult;
import com.xxxJppp.cloud.common.model.Result;

/**
 * 参数配置
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Api(tags = "参数配置")
@RestController
@RequestMapping("config")
public class SysConfigController extends BaseController {
    @Autowired
    private ISysConfigService sysConfigService;

    /**
     * 查询列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sortField", value = "排序字段", dataType = "String"),
            @ApiImplicitParam(name = "sortOrder", value = "排序方式（升序asc或降序desc，不传默认升序）", dataType = "String")
    })
    @GetMapping("/list")
    public PageResult list(SysConfig sysConfig) {
        Page page = getPage();
        return sysConfigService.findListByPage(page,sysConfig);
    }
    /**
     * 查询${tableComment}
     */
    @ApiOperation(value = "查询")
    @GetMapping(value = "/{configId}")
    public Result get(@PathVariable("configId") Integer configId) {
        SysConfig model = sysConfigService.getById(configId);
        return Result.succeed(model);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增")
    @PostMapping
    public Result save(SysConfig sysConfig) {
        sysConfigService.save(sysConfig);
        return Result.succeed();
    }

    /**
    * 编辑
    */
    @ApiOperation(value = "编辑")
    @PutMapping
    public Result update(SysConfig sysConfig) {
        sysConfigService.updateById(sysConfig);
        return Result.succeed();
    }


    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{configId}")
    public Result delete(@PathVariable("configId") Integer configId) {
        sysConfigService.removeById(configId);
        return Result.succeed();
    }
}
