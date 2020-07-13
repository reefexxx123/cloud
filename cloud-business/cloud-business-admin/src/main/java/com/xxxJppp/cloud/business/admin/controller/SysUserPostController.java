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

import com.xxxJppp.cloud.business.admin.model.SysUserPost;
import com.xxxJppp.cloud.business.admin.service.ISysUserPostService;
import com.xxxJppp.cloud.common.model.PageResult;
import com.xxxJppp.cloud.common.model.Result;

/**
 * 用户与岗位关联
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Api(tags = "用户与岗位关联")
@RestController
@RequestMapping("userpost")
public class SysUserPostController extends BaseController {
    @Autowired
    private ISysUserPostService sysUserPostService;

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
    public PageResult list(SysUserPost sysUserPost) {
        Page page = getPage();
        return sysUserPostService.findListByPage(page,sysUserPost);
    }
    /**
     * 查询${tableComment}
     */
    @ApiOperation(value = "查询")
    @GetMapping(value = "/{userId}")
    public Result get(@PathVariable("userId") Long userId) {
        SysUserPost model = sysUserPostService.getById(userId);
        return Result.succeed(model);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增")
    @PostMapping
    public Result save(SysUserPost sysUserPost) {
        sysUserPostService.save(sysUserPost);
        return Result.succeed();
    }

    /**
    * 编辑
    */
    @ApiOperation(value = "编辑")
    @PutMapping
    public Result update(SysUserPost sysUserPost) {
        sysUserPostService.updateById(sysUserPost);
        return Result.succeed();
    }


    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{userId}")
    public Result delete(@PathVariable("userId") Long userId) {
        sysUserPostService.removeById(userId);
        return Result.succeed();
    }
}
