package com.xxxJppp.cloud.common.serialize;

import java.lang.reflect.Type;

/**
 * 序列化接口
 *
 * @author xxxJppp
 * @date 2020/4/17 15:36
 */
public interface Serializer {

    String serialize(Object object);

    <T> T deserialize(String str, Type type);

}
