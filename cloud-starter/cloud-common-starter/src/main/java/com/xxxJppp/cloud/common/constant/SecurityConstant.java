package com.xxxJppp.cloud.common.constant;

/**
 * 安全常用类
 *
 * @author xxxJppp
 * @date 2020/4/29 20:23
 */
public interface SecurityConstant {

    String OAUTH_TOKEN_URL = "/oauth/token/user";

    String HEADER_AUTHORIZATION = "Authorization";
    String BASIC_PREFIX = "Basic ";
    /**
     * 令牌类型
     */
    String BEARER_TOKEN_TYPE = "Bearer";

    String PHONE_KEY = "phone";

    String SMS_CODE = "smsCode";

    /**
     * 用户ID字段
     */
    String DETAILS_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    String DETAILS_USERNAME = "username";

    /**
     * oauth_client_details 表的字段 {scrypt}
     */
    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     * JdbcClientDetailsService 查询语句
     */
    String BASE_FIND = "select " + CLIENT_FIELDS + " from oauth_client_details";

    /**
     * 默认的查询语句
     */
    String DEFAULT_FIND = BASE_FIND + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    String DEFAULT_SELECT = BASE_FIND + " where client_id = ?";

    /**
     * 资源服务器默认bean名称
     */
    String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";

    /**
     * 资源服务器配置文件bean名称
     */
    String RESOURCE_SERVER_PROPERTIES = "resourceServerProperties";

    String NORMAL = "normal";
    String SMS = "sms";
    String LOGIN_QQ = "qq";
    String LOGIN_WEIXIN = "weixin";
    String LOGIN_GITEE = "gitee";
    String LOGIN_GITHUB = "github";

    /**
     * 用户信息头
     */
    String USER_HEADER = "x-user-name-header";
    /**
     * 用户id信息头
     */
    String USER_ID_HEADER = "x-user-id-header";
    /**
     * 角色信息头
     */
    String ROLE_HEADER = "x-role-header";
    /**
     * 租户信息头(应用)
     */
    String TENANT_HEADER = "x-tenant-header";
    /**
     * 角色前缀
     */
    String ROLE = "ROLE_";
    /**
     * 基础角色
     */
    String BASE_ROLE = "ROLE_USER";
    /**
     * 授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";
    /**
     * 密码模式
     */
    String PASSWORD = "password";
    /**
     * 默认生成图形验证码宽度
     */
    String DEFAULT_IMAGE_WIDTH = "100";
    /**
     * 默认生成图像验证码高度
     */
    String DEFAULT_IMAGE_HEIGHT = "35";
    /**
     * 默认生成图形验证码长度
     */
    String DEFAULT_IMAGE_LENGTH = "4";
    /**
     * 默认生成图形验证码过期时间
     */
    int DEFAULT_IMAGE_EXPIRE = 12000000;
    /**
     * 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
     */
    String DEFAULT_COLOR_FONT = "blue";
    /**
     * 图片边框
     */
    String DEFAULT_IMAGE_BORDER = "no";
    /**
     * 默认图片间隔
     */
    String DEFAULT_CHAR_SPACE = "5";
    /**
     * 默认保存手机验证码code的前缀
     */
    String DEFAULT_SMS_CODE_KEY = "default_sms_code_key";
    /**
     * 验证码文字大小
     */
    String DEFAULT_IMAGE_FONT_SIZE = "30";
    /**
     * 缓存client的redis key，这里是hash结构存储
     */
    String CACHE_CLIENT_KEY = "oauth_client_details";
    /**
     * 默认token过期时间(1小时)
     */
    Integer ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60 * 60;
    /**
     * redis中授权token对应的key
     */
    String REDIS_TOKEN_AUTH = "auth:";
    /**
     * redis中应用对应的token集合的key
     */
    String REDIS_CLIENT_ID_TO_ACCESS = "client_id_to_access:";
    /**
     * redis中用户名对应的token集合的key
     */
    String REDIS_UNAME_TO_ACCESS = "uname_to_access:";
    /**
     * 标志
     */
    String FROM = "from";

    /**
     * oauth 缓存前缀
     */
    String OAUTH_ACCESS = "oauth:access:";

    /**
     * oauth 客户端信息
     */
    String CLIENT_DETAILS_KEY = "oauth:client:details";
}
