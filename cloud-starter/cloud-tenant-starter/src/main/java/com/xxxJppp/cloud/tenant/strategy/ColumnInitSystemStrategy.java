package com.xxxJppp.cloud.tenant.strategy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.xxxJppp.cloud.common.context.TenantContextHolder;
import com.xxxJppp.cloud.data.properties.DatabaseProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 初始化规则:
 * 手动创建数据
 *
 * @author xxxJppp
 * @date 2020年04月05日13:14:28
 */
@Service("COLUMN")
@Slf4j
public class ColumnInitSystemStrategy implements InitSystemStrategy {
    @Autowired
    private DatabaseProperties databaseProperties;

    /**
     * 我*，这种方式太脑残了，但想不出更好的方式初始化数据，希望各位大神有好的初始化方法记得跟我说声！！！
     * 写这段代码写得想去si ~~~
     * <p>
     * 不能用 SCHEMA 模式的初始化脚本方法： 因为id 会重复，租户编码会重复！
     *
     * @param tenant 待初始化租户编码
     * @return
     */
    @Override
    public boolean init(String tenant) {
        // 初始化数据
        //1, 生成并关联 ID TENANT
        DatabaseProperties.Id id = databaseProperties.getId();
        Snowflake snowflake = IdUtil.getSnowflake(id.getWorkerId(), id.getDataCenterId());

        TenantContextHolder.setTenant(tenant);

        // 菜单 资源 角色 角色_资源 字典 参数


        // 角色

        // 资源权限

        // 字典

        //参数

        return true;
    }

    @Override
    public boolean reset(String tenant) {
        //TODO 待实现
        // 1，清空所有表的数据
        // 2，重新初始化 tenant
        // 3，重新初始化 业务数据
        //        init(tenant);
        return true;
    }

    @Override
    public boolean delete(List<String> tenantCodeList) {
        // 清空所有表中当前租户的数据
        //TODO 待实现
        //1,查询系统中的所有表
        //删除该租户的所有数据
        return true;
    }
}
