package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 字典类型对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_type")
public class SysDictType extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 字典主键 */
private Long dictId;
/** 字典名称 */
private String dictName;
/** 字典类型 */
private String dictType;
/** 状态（0正常 1停用） */
private String status;
}
