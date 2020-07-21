package com.xxxJppp.cloud.tenant.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxJppp.cloud.tenant.mapper.TenantDataSourceMapper;
import com.xxxJppp.cloud.tenant.model.TenantDataSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 瑞夫
 * @version 1.0
 * @Description
 * @date 2020/7/21
 **/
@Component("defaultTenantDataSourceService")
public class DefaultTenantDataSourceService extends ServiceImpl<TenantDataSourceMapper, TenantDataSource> implements ITenantDataSourceService {

    @Override
    public List<TenantDataSource> findAllUsedDataSource() {
        return list();
    }

    @Override
    public TenantDataSource findOneUsedDataSource(String tenantCode) {
        LambdaQueryWrapper<TenantDataSource> select = Wrappers.<TenantDataSource>lambdaQuery()
                .eq(TenantDataSource::getTenantCode, tenantCode);
        return getOne(select);
    }

    @Override
    public Boolean existTenant(String tenantCode) {
        LambdaQueryWrapper<TenantDataSource> select = Wrappers.<TenantDataSource>lambdaQuery()
                .eq(TenantDataSource::getTenantCode, tenantCode).last("LIMIT 1");
        return getOne(select) != null;
    }
}
