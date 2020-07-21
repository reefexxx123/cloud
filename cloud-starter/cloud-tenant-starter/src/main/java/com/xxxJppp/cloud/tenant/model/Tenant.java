package com.xxxJppp.cloud.tenant.model;

import com.baomidou.mybatisplus.annotation.*;
import com.xxxJppp.cloud.common.enums.TenantStatusEnum;
import com.xxxJppp.cloud.common.enums.TenantTypeEnum;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 企业
 * </p>
 *
 * @author zuihou
 * @since 2019-10-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@TableName("d_tenant")
public class Tenant  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 企业编码
     */
    @Length(max = 20, message = "企业编码长度不能超过20")
    @TableField(value = "code", condition = LIKE)
    private String code;

    /**
     * 企业名称
     */
    @Length(max = 255, message = "企业名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 类型
     * #{CREATE:创建;REGISTER:注册}
     */
    @TableField("type")
    private TenantTypeEnum type;

    /**
     * 状态
     * #{NORMAL:正常;FORBIDDEN:禁用;WAITING:待审核;REFUSE:拒绝}
     */
    @TableField("status")
    private TenantStatusEnum status;

    @TableField("readonly")
    private Boolean readonly;

    /**
     * 责任人
     */
    @Length(max = 50, message = "责任人长度不能超过50")
    @TableField(value = "duty", condition = LIKE)
    private String duty;

    /**
     * 有效期
     * 为空表示永久
     */
    @TableField("expiration_time")
    private LocalDateTime expirationTime;

    /**
     * logo地址
     */
    @Length(max = 255, message = "logo地址长度不能超过255")
    @TableField(value = "logo", condition = LIKE)
    private String logo;

    /**
     * 企业简介
     */
    @Length(max = 255, message = "企业简介长度不能超过255")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

    @Builder
    public Tenant(Long id, Date createTime, Long createUser, Date updateTime, Long updateUser,
                  String code, String name, TenantTypeEnum type, TenantStatusEnum status, String duty,
                  LocalDateTime expirationTime, Boolean readonly, String logo, String describe) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.readonly = readonly;
        this.code = code;
        this.name = name;
        this.type = type;
        this.status = status;
        this.duty = duty;
        this.expirationTime = expirationTime;
        this.logo = logo;
        this.describe = describe;
    }

}
