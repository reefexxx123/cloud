package com.xxxJppp.cloud.data.datasource;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xxxJppp.cloud.auth.utils.SecurityUtils;
import com.xxxJppp.cloud.common.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * MyBatis Plus 元数据处理类
 * 用于自动 注入 id, createTime, updateTime, createUser, updateUser 等字段
 * <p>
 * 判断逻辑：
 * 1. insert 方法，自动填充 id, createTime, updateTime, createBy, updateBy 字段，字段为空则自动生成，不为空则使用传递进来的
 * 2. update 方法，自动填充 id, updateTime, updateBy 字段，字段为空则自动生成，不为空则使用传递进来的
 * <p>
 * 注入值：
 * id：  IdUtil.getSnowflake(workerId, dataCenterId);
 *
 * @author xxxJppp
 * @date 2020/7/17
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * id类型判断符
     */
    private final static String ID_TYPE = "java.lang.String";

    private long workerId;
    private long dataCenterId;

    /**
     * @param workerId     终端ID
     * @param dataCenterId 数据中心ID
     */
    public MyMetaObjectHandler(long workerId, long dataCenterId) {
        super();
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 注意：不支持 复合主键 自动注入！！
     * <p>
     * 所有的继承了BaseEntity的实体，在insert时，
     * id： id为空时， 通过IdGenerate生成唯一ID， 不为空则使用传递进来的id
     * createUser, updateUser: 自动赋予 当前线程上的登录人id
     * createTime, updateTime: 自动赋予 服务器的当前时间
     * <p>
     * 未继承任何父类的实体，且主键标注了 @TableId(value = "xxx", type = IdType.INPUT) 自动注入 主键
     * 主键的字段名称任意
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean flag = true;
        // 设置创建时间和创建人
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) metaObject.getOriginalObject();
            if (entity.getCreateTime() == null) {
                this.setFieldValByName(BaseEntity.CREATE_TIME, new Date(), metaObject);
            }
            if (entity.getCreateBy() == null || entity.getCreateBy().equals(0)) {
                Object userIdVal = ID_TYPE.equals(metaObject.getGetterType(BaseEntity.CREATE_USER).getName()) ? String.valueOf(SecurityUtils.getUser().getUserId()) : SecurityUtils.getUser().getUserId();
                this.setFieldValByName(BaseEntity.CREATE_USER, userIdVal, metaObject);
            }
        }

        // 修改人 修改时间
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) metaObject.getOriginalObject();
            update(metaObject, entity);
        }

        // 若 ID 中有值，就不设置
        if (!flag) {
            return;
        }
        Snowflake snowflake = IdUtil.getSnowflake(workerId, dataCenterId);
        Long id = snowflake.nextId();
        TableInfo tableInfo = metaObject.hasGetter(Constants.MP_OPTLOCK_ET_ORIGINAL) ?
                TableInfoHelper.getTableInfo(metaObject.getValue(Constants.MP_OPTLOCK_ET_ORIGINAL).getClass())
                : TableInfoHelper.getTableInfo(metaObject.getOriginalObject().getClass());
        if (tableInfo == null) {
            return;
        }
        // 主键类型
        Class<?> keyType = tableInfo.getKeyType();
        if (keyType == null) {
            return;
        }
        // id 字段名
        String keyProperty = tableInfo.getKeyProperty();

        // 反射得到 主键的值
        Field idField = ReflectUtil.getField(metaObject.getOriginalObject().getClass(), keyProperty);
        Object fieldValue = ReflectUtil.getFieldValue(metaObject.getOriginalObject(), idField);
        // 判断ID 是否有值，有值就不
        if (ObjectUtil.isNotEmpty(fieldValue)) {
            return;
        }
        Object idVal = keyType.getName().equalsIgnoreCase(ID_TYPE) ? String.valueOf(id) : id;
        this.setFieldValByName(keyProperty, idVal, metaObject);
    }

    private void update(MetaObject metaObject, BaseEntity entity, String et) {
        if (entity.getUpdateBy() == null || entity.getUpdateBy().equals(0)) {
            Object userIdVal = ID_TYPE.equals(metaObject.getGetterType(et + BaseEntity.UPDATE_USER).getName()) ? String.valueOf(SecurityUtils.getUser().getUserId()) : SecurityUtils.getUser().getUserId();
            this.setFieldValByName(BaseEntity.UPDATE_USER, SecurityUtils.getUser().getUserId(), metaObject);
        }
        if (entity.getUpdateTime() == null) {
            this.setFieldValByName(BaseEntity.UPDATE_TIME, new Date(), metaObject);
        }
    }

    private void update(MetaObject metaObject, BaseEntity entity) {
        update(metaObject, entity, "");
    }

    /**
     * 所有的继承了BaseEntity的实体，在update时，
     * updateUser: 自动赋予 当前线程上的登录人id
     * updateTime: 自动赋予 服务器的当前时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("start update fill ....");
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) metaObject.getOriginalObject();
            update(metaObject, entity);
        } else {
            //updateById updateBatchById update(T entity, Wrapper<T> updateWrapper);
            Object et = metaObject.getValue(Constants.ENTITY);
            if (et != null && et instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) et;
                update(metaObject, entity, Constants.ENTITY + ".");
            }
        }
    }
}
