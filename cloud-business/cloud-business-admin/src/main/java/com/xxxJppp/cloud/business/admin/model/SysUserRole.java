package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 用户和角色关联对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 用户ID */
private Long userId;
/** 角色ID */
private Long roleId;
}
