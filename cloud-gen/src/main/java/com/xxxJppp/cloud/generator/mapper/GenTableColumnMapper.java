package com.xxxJppp.cloud.generator.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxJppp.cloud.generator.model.GenTableColumn;
import org.apache.ibatis.annotations.Mapper;

/**
 * 业务字段 数据层
 *
 * @author xxxJppp
 */
public interface GenTableColumnMapper extends BaseMapper<GenTableColumn> {
    /**
     * 根据表名称查询列信息
     *
     * @param tableName 表名称
     * @return 列信息
     */
    List<GenTableColumn> selectDbTableColumnsByName(String tableName);

    /**
     * 查询业务字段列表
     *
     * @param tableId 业务字段信息
     * @return 业务字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    /**
     * 新增业务字段
     *
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    int insertGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 修改业务字段
     *
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    int updateGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 批量删除业务字段
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteGenTableColumnByIds(Long[] ids);
}