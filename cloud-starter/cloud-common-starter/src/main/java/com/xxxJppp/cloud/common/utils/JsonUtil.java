package com.xxxJppp.cloud.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xxxJppp.cloud.common.serialize.JsonSerializer;

import java.lang.reflect.Type;

/**
 * JsonUtils
 *
 * @author xxxJppp
 * @date 2020/6/2 16:36
*/
public class JsonUtil {
    public static JsonSerializer Default = new JsonSerializer();

    public static String serialize(Object object) {
        return Default.serialize(object);
    }

    public static <T> T deserialize(String str, Type type) {
        return Default.deserialize(str, type);
    }

    public static <T> T deserialize(String str, TypeReference<T> type) {
        return Default.deserialize(str, type.getType());
    }
}
