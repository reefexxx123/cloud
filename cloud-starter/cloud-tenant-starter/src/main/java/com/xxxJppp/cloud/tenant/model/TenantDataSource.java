package com.xxxJppp.cloud.tenant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 *
 * @author 瑞夫
 * @version 1.0
 * @date 2020/7/18
 */
@Slf4j
@Data
@TableName("d_tenant_datasource")
@NoArgsConstructor
public class TenantDataSource implements Serializable {

    private static final long serialVersionUID = 2388259049600058394L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @TableField("tenant_code")
    private String tenantCode;

    @TableField("datasource_url")
    private String dataSourceUrl;

    @TableField("datasource_username")
    private String dataSourceUsername;

    @TableField("datasource_password")
    private String dataSourcePassword;

    @TableField("datasource_driver")
    private String dataSourceDriver;

    @TableField("datasource_type")
    private String dataSourceType;
}
