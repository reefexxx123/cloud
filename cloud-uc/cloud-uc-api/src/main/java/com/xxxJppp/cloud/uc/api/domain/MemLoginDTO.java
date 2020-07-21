package com.xxxJppp.cloud.uc.api.domain;

import com.xxxJppp.cloud.uc.api.entity.SysRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 会员登录账号
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
@Data
public class MemLoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
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
     * 部门ID
     */
    private Long deptId;

    /**
     * 支付密码md5
     */
    private String payPassword;

    /**
     * 账号状态 1正常 0禁止登陆
     */
    private Boolean status;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 登录总次数
     */
    private Integer loginNum;

    /**
     * 登录ip地址
     */
    private String clientIp;

    /**
     * 谷歌令牌密钥
     */
    private String googleSecretKey;


    /** 角色对象 */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;


    @Override
    public String toString() {
        return "MemLoginDTO{" +
                "id=" + id +
                ", accno='" + accno + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", loginType=" + loginType +
                ", payPassword='" + payPassword + '\'' +
                ", status=" + status +
                ", lastLoginTime=" + lastLoginTime +
                ", loginNum=" + loginNum +
                ", clientIp='" + clientIp + '\'' +
                ", googleSecretKey='" + googleSecretKey + '\'' +
                ", roles=" + roles +
                ", roleIds=" + Arrays.toString(roleIds) +
                ", postIds=" + Arrays.toString(postIds) +
                '}';
    }
}
