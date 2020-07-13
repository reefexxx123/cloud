package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 部门对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dept")
public class SysDept extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 部门id */
private Long deptId;
/** 父部门id */
private Long parentId;
/** 祖级列表 */
private String ancestors;
/** 部门名称 */
private String deptName;
/** 显示顺序 */
private Integer orderNum;
/** 负责人 */
private String leader;
/** 联系电话 */
private String phone;
/** 邮箱 */
private String email;
/** 部门状态（0正常 1停用） */
private String status;
/** 删除标志（0代表存在 2代表删除） */
private String delFlag;
}
