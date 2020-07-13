package com.xxxJppp.cloud.generator.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxJppp.cloud.common.model.PageResult;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.utils.StringUtils;
import com.xxxJppp.cloud.generator.model.GenTable;
import com.xxxJppp.cloud.generator.model.GenTableColumn;
import com.xxxJppp.cloud.generator.service.IGenTableColumnService;
import com.xxxJppp.cloud.generator.service.IGenTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成 操作处理
 *
 * @author xxxJppp
 */
@Api(tags = "代码生成")
@RestController
@RequestMapping("/gen")
public class GenController {
    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    /**
     * 查询代码生成列表
     */
    @ApiOperation("查询代码生成列表")
    @GetMapping("/list")
    public PageResult genList(GenTable genTable) {
        Page<GenTable> page = new Page();
        List<GenTable> list = genTableService.selectGenTableList(genTable,page);
        page.setRecords(list);
        return PageResult.succeed(page);
    }


    /**
     * 修改代码生成业务
     */
    @ApiOperation("修改代码生成业务")
    @GetMapping(value = "/genTable/{talbleId}")
    public Result getInfo(@PathVariable Long talbleId)
    {
        GenTable table = genTableService.selectGenTableById(talbleId);
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(talbleId);
        Map<String, Object> map = new HashMap<>();
        map.put("info", table);
        map.put("rows", list);
        return Result.succeed(map);
    }

    /**
     * 导入表结构（保存）
     */
    @ApiOperation("导入表结构")
    @PostMapping("/importTable")
    public Result importTableSave(String tables) {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        genTableService.importGenTable(tableList, null);
        return Result.succeed(null);
    }

    /**
     * 修改保存代码生成业务
     */
    @PutMapping
    public Result editSave(@Validated @RequestBody GenTable genTable){
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return Result.succeed(null);
    }

    /**
     * 删除代码生成
     */
    @DeleteMapping("/{tableIds}")
    public Result remove(@PathVariable Long[] tableIdstableIds){
        genTableService.deleteGenTableByIds(StringUtils.join(tableIdstableIds, ","));
        return Result.succeed(null);
    }

    /**
     * 预览代码
     */
    @ApiOperation("在线预览代码")
    @GetMapping("/preview/{tableId}")
    public Result preview(@PathVariable("tableId") Long tableId){
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return Result.succeed(dataMap);
    }


    /**
     * 生成代码
     */
    @ApiOperation("代码生成接口")
    @GetMapping("/genCode/{tableName}")
    public void genCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = genTableService.generatorCode(tableName);
        genCode(response, data);
    }

    /**
     * 批量生成代码
     */
    @ApiOperation("下载代码")
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.generatorCode(tableNames);
        genCode(response, data);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=genCode.zip");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}