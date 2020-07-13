package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 角色信息对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRole extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 角色ID */
private Long roleId;
/** 角色名称 */
private String roleName;
/** 角色权限字符串 */
private String roleKey;
/** 显示顺序 */
private Integer roleSort;
/** 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） */
private String dataScope;
/** 角色状态（0正常 1停用） */
private String status;
/** 删除标志（0代表存在 2代表删除） */
private String delFlag;
}
