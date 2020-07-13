package com.xxxJppp.cloud.business.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxJppp.cloud.business.admin.model.MemLogin;
import com.xxxJppp.cloud.business.admin.service.IMemLoginService;
import com.xxxJppp.cloud.common.base.BaseController;
import com.xxxJppp.cloud.common.model.PageResult;
import com.xxxJppp.cloud.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录账号
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Api(tags = "会员登录账号")
@RestController
@RequestMapping("login")
public class MemLoginController extends BaseController {
    @Autowired
    private IMemLoginService memLoginService;


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
    public PageResult list(MemLogin memLogin) {
        Page page = getPage();
        return memLoginService.findListByPage(page,memLogin);
    }
    /**
     * 查询${tableComment}
     */
    @ApiOperation(value = "查询")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable("id") Long id) {
        MemLogin model = memLoginService.getById(id);
        return Result.succeed(model);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增")
    @PostMapping
    public Result save(MemLogin memLogin) {
        memLoginService.save(memLogin);
        return Result.succeed();
    }

    /**
    * 编辑
    */
    @ApiOperation(value = "编辑")
    @PutMapping
    public Result update(MemLogin memLogin) {
        memLoginService.updateById(memLogin);
        return Result.succeed();
    }


    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id) {
        memLoginService.removeById(id);
        return Result.succeed();
    }

}
