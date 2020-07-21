package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 会员登录账号对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("mem_login")
public class MemLogin extends Model {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 会员标识号
     */
    private String accno;
    /**
     * 登录账号(登录用)
     */
    private String loginname;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 账户类型  普通会员1      主播2   家族長3  代充人4  运营后台管理员8    第三方登录7   服務註冊中心管理員9  聚合站点后台管理员10
     */
    private Integer loginType;
    /**
     * 支付密码md5
     */
    private String payPassword;
    /**
     * 账号状态 1正常 0禁止登陆
     */
    private Integer status;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 登录总次数
     */
    private Long loginNum;
    /**
     * 登录ip地址
     */
    private String clientIp;
    /**
     * 谷歌令牌密钥
     */
    private String googleSecretKey;
}
