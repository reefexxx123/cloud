package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 通知公告对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_notice")
public class SysNotice extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 公告ID */
private Integer noticeId;
/** 公告标题 */
private String noticeTitle;
/** 公告类型（1通知 2公告） */
private String noticeType;
/** 公告内容 */
private String noticeContent;
/** 公告状态（0正常 1关闭） */
private String status;
}
