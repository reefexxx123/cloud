package com.xxxJppp.cloud.tenant.properties;

import com.xxxJppp.cloud.common.constant.StarterNameConstant;
import com.xxxJppp.cloud.common.enums.MultiTenantTypeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.xxxJppp.cloud.common.enums.MultiTenantTypeEnum.SCHEMA;

/**
 * 多租户配置
 *
 * @author xxxJppp
 * @date 2020/5/2 11:19
*/
@Slf4j
@Configuration
@Data
@ConfigurationProperties(prefix = "cloud.tenant")
public class TenantProperties {

    public TenantProperties() {
        log.info("[CLOUD][" + StarterNameConstant.CLOUD_DATA_STARTER + "]" + "，加载[TenantProperties]配置");
    }
    /**
     * 是否开启多租户
     */
    private Boolean enabled = false;

    /**
     * 配置不进行多租户隔离的表名
     */
    private List<String> ignoreTables = new ArrayList<>();

    /**
     * 配置不进行多租户隔离的sql
     * 需要配置mapper的全路径如：com.central.user.mapper.SysUserMapper.findList
     */
    private List<String> ignoreSqls = new ArrayList<>();
    /**
     * 租户库 前缀
     */

    private String tenantDatabasePrefix = "cloud_base";
    /**
     *
     * 多租户模式
     */
    private MultiTenantTypeEnum multiTenantType = SCHEMA;
    /**
     * 租户id 列名
    */
    private String tenantIdColumn = "tenant_code";
}
