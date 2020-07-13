package com.xxxJppp.cloud.uc.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员登录账号
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public class MemLogin extends Model<MemLogin> {

    private static final long serialVersionUID = 1L;

        /**
     * 用户id
     */
         @TableId(value = "id", type = IdType.AUTO)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getGoogleSecretKey() {
        return googleSecretKey;
    }

    public void setGoogleSecretKey(String googleSecretKey) {
        this.googleSecretKey = googleSecretKey;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MemLogin{" +
        "id=" + id +
        ", accno=" + accno +
        ", loginname=" + loginname +
        ", password=" + password +
        ", loginType=" + loginType +
        ", payPassword=" + payPassword +
        ", status=" + status +
        ", lastLoginTime=" + lastLoginTime +
        ", loginNum=" + loginNum +
        ", clientIp=" + clientIp +
        ", googleSecretKey=" + googleSecretKey +
        "}";
    }
}
