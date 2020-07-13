package com.xxxJppp.cloud.common.constant;

/**
 * 全局公共常量
 *
 * @author xxxJppp
 * @date 2020/4/30 10:23
 */
public interface CommonConstant {
    /**
     * 邮箱
     */
    String RESET_MAIL = "MAIL";

    /**
     * 短信验证码
     */
    String SMS_KEY = "SMS_CODE_";

    /**
     * 操作日志类型： 查询/获取
     */
    int OPERATE_TYPE_1 = 1;

    /**
     * 操作日志类型： 添加
     */
    int OPERATE_TYPE_2 = 2;

    /**
     * 操作日志类型： 更新
     */
    int OPERATE_TYPE_3 = 3;

    /**
     * 操作日志类型： 删除
     */
    int OPERATE_TYPE_4 = 4;

    /**
     * 项目版本号(banner使用)
     */
    String PROJECT_VERSION = "3.5.0";

    /**
     * token请求头名称
     */
    String TOKEN_HEADER = "Authorization";

    /**
     * ACCESS_TOKEN
     */
    String ACCESS_TOKEN = "access_token";

    /**
     * Bearer
     */
    String BEARER_TYPE = "Bearer";

    /**
     * 标签且 名称
     */
    String LABEL_AND = "labelAnd";

    /**
     * 权重key
     */
    String WEIGHT_KEY = "weight";

    /**
     * 删除
     */
    String STATUS_DEL = "1";

    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 目录
     */
    Integer CATALOG = -1;

    /**
     * 菜单
     */
    Integer MENU = 1;

    /**
     * 权限
     */
    Integer PERMISSION = 2;

    /**
     * 删除标记
     */
    String DEL_FLAG = "is_del";

    /**
     * 超级管理员用户名
     */
    String ADMIN_USER_NAME = "admin";

    /**
     * 公共日期格式
     */
    String MONTH_FORMAT = "yyyy-MM";
    String DATE_FORMAT = "yyyy-MM-dd";
    String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String SIMPLE_MONTH_FORMAT = "yyyyMM";
    String SIMPLE_DATE_FORMAT = "yyyyMMdd";
    String SIMPLE_DATETIME_FORMAT = "yyyyMMddHHmmss";
    String DEF_USER_PASSWORD = "123456";
    String LOCK_KEY_PREFIX = "LOCK_KEY:";

    /**
     * 租户id参数
     */
    String TENANT_ID_PARAM = "t-tenantId";
    /**
     * 日志链路追踪id信息头
     */
    String TRACE_ID_HEADER = "t-traceId-header";
    /**
     * 日志链路追踪id日志标志
     */
    String LOG_TRACE_ID = "t-traceId";
    /**
     * 负载均衡策略-版本号 信息头
     */
    String T_T_VERSION = "t-version";
    /**
     * 注册中心元数据 版本号
     */
    String METADATA_VERSION = "version";
    /**
     * 验证码 redis key
     */
    String CAPTCHA_CODE_KEY = "captcha_key:";
    /**
     * 验证码有效期（秒）
     */
    Integer CAPTCHA_EXPIRATION = 2*60;
}
