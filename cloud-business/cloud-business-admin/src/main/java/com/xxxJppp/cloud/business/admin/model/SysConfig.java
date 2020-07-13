package com.xxxJppp.cloud.business.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.xxxJppp.cloud.common.base.BaseEntity;

/**
 * 参数配置对象
 *
 * @author xxxJppp
 * @date 2020-07-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_config")
public class SysConfig extends BaseEntity {
    private static final long serialVersionUID=1L;

/** 参数主键 */
private Integer configId;
/** 参数名称 */
private String configName;
/** 参数键名 */
private String configKey;
/** 参数键值 */
private String configValue;
/** 系统内置（Y是 N否） */
private String configType;
}
