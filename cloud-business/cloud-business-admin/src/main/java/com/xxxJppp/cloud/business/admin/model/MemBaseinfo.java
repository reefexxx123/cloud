package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 会员基本信息对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("mem_baseinfo")
public class MemBaseinfo extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 用户id */
private Long memid;
/** 会员标识号 */
private String accno;
/** 呢称 */
private String nickName;
/** 真实姓名 */
private String memName;
/** 手机号码 */
private String mobile;
/** 性别 1男 2女 4保密 */
private Long sex;
/** 证件类型DDINFO */
private String idcardType;
/** 证件号码 */
private String idcardNo;
/** 证件照片正面 */
private String idcardFront;
/** 证件照片反面 */
private String idcardBack;
/** 出生日期 */
private Date birthday;
/** 国籍DDINFO */
private String nationality;
/** 头像 */
private String headimg;
/** 注册日期 */
private Date registerdate;
/** 推荐码 */
private String recomcode;
/** 描述 */
private String describes;
/** 登录地址城市 */
private String tag;
/** 登录国家 */
private String logincountry;
/** 会员特征(兴趣) */
private String memfeatures;
/** 来源 recommend推荐  regist注册  operator运营人员 */
private String memorgin;
/** 粉丝数量 */
private Long fansnum;
/** 用户乐币数量 */
private Double goldnum;
/** 所在地(省市区)12位區域編碼code */
private String sitearea;
/** 微信号 */
private String wechat;
/** 微信昵称 */
private String chatnickName;
/** 删除标志 0或空未删除 1已删除 */
private Integer delete;
/** 创建人 */
private String createUser;
/** 创建时间 */
private Date createDate;
/** 最后修改人 */
private String modifyUser;
/** 最后修改时间 */
private Date modifyDate;
}
