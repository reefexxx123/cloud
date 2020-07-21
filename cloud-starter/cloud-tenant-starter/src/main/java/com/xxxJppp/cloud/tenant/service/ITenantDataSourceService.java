package com.xxxJppp.cloud.tenant.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxJppp.cloud.tenant.model.TenantDataSource;

import java.util.List;

/**
 *
 * @author 瑞夫
 * @version 1.0
 * @date 2020/7/18
 */
public interface ITenantDataSourceService extends IService<TenantDataSource> {

    /**
     * 查询所有可用的租户数据源
     * @author WangMingShuai
     */
    List<TenantDataSource> findAllUsedDataSource();

    /**
     * 根据数据源名称查询数据源信息
     * @param   tenantCode 租户编号
     */
    TenantDataSource findOneUsedDataSource(String tenantCode);

    /**
     * 是否存在租户
     * @param tenantCode 租户编号
     * @return
     */
    Boolean existTenant(String tenantCode);
}
