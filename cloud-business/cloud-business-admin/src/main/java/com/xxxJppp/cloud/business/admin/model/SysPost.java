package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 岗位信息对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_post")
public class SysPost extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 岗位ID */
private Long postId;
/** 岗位编码 */
private String postCode;
/** 岗位名称 */
private String postName;
/** 显示顺序 */
private Integer postSort;
/** 状态（0正常 1停用） */
private String status;
}
