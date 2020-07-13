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

import com.xxxJppp.cloud.business.admin.model.SysMenu;
import com.xxxJppp.cloud.business.admin.service.ISysMenuService;
import com.xxxJppp.cloud.common.model.PageResult;
import com.xxxJppp.cloud.common.model.Result;

/**
 * 菜单权限
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Slf4j
@Api(tags = "菜单权限")
@RestController
@RequestMapping("menu")
public class SysMenuController extends BaseController {
    @Autowired
    private ISysMenuService sysMenuService;

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
    public PageResult list(SysMenu sysMenu) {
        Page page = getPage();
        return sysMenuService.findListByPage(page,sysMenu);
    }
    /**
     * 查询${tableComment}
     */
    @ApiOperation(value = "查询")
    @GetMapping(value = "/{menuId}")
    public Result get(@PathVariable("menuId") Long menuId) {
        SysMenu model = sysMenuService.getById(menuId);
        return Result.succeed(model);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增")
    @PostMapping
    public Result save(SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Result.succeed();
    }

    /**
    * 编辑
    */
    @ApiOperation(value = "编辑")
    @PutMapping
    public Result update(SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return Result.succeed();
    }


    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{menuId}")
    public Result delete(@PathVariable("menuId") Long menuId) {
        sysMenuService.removeById(menuId);
        return Result.succeed();
    }
}
