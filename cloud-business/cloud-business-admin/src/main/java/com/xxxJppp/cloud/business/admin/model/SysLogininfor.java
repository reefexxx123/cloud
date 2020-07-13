package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 系统访问记录对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_logininfor")
public class SysLogininfor extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 访问ID */
private Long infoId;
/** 用户账号 */
private String userName;
/** 登录IP地址 */
private String ipaddr;
/** 登录状态（0成功 1失败） */
private String status;
/** 提示信息 */
private String msg;
/** 访问时间 */
private Date accessTime;
}
