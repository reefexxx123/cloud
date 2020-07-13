package com.xxxJppp.cloud.common.enums;


import com.xxxJppp.cloud.common.constant.SecurityConstant;

/**
 * 登录类型 现在有用户名 短信 社交
 *
 * @author xxxJppp
 * @date 2020/4/29 18:11
 */
public enum LoginTypeEnum {
    /**
     * 用户密码登录
     */
    normal(SecurityConstant.NORMAL, "用户密码登录"),
    /**
     * 短信密码登录
     */
    sms(SecurityConstant.SMS, "短信密码登录"),
    /**
     * 社交登录
     */
    qq(SecurityConstant.LOGIN_QQ, "qq登录"),
    weixin(SecurityConstant.LOGIN_WEIXIN, "微信登录"),
    gitee(SecurityConstant.LOGIN_GITEE, "gitee登录"),
    github(SecurityConstant.LOGIN_GITHUB, "github登录");

    private String type;
    private String description;

    LoginTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
