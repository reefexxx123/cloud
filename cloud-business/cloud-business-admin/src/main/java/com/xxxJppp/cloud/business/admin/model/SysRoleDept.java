package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 角色和部门关联对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_dept")
public class SysRoleDept extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 角色ID */
private Long roleId;
/** 部门ID */
private Long deptId;
}
