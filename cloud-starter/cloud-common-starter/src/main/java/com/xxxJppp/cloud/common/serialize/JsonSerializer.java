package com.xxxJppp.cloud.common.serialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xxxJppp.cloud.common.exception.BaseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * json 序列化
 *
 * @author xxxJppp
 * @date 2020/4/17 15:35
 */
public class JsonSerializer implements Serializer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .enable(MapperFeature.USE_ANNOTATIONS)
            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setTimeZone(TimeZone.getTimeZone("GMT+8"))
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    @Override
    public String serialize(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            throw new BaseException("序列化失败，对象：" + object, e);
        }
    }

    @Override
    public <T> T deserialize(String str, Type type) {
        try {
            return (T) OBJECT_MAPPER.readValue(str, new TypeReference<Object>() {
                @Override
                public Type getType() {
                    return type;
                }
            });
        } catch (Exception e) {
            throw new BaseException("反序列化失败，类型：" + type + "，JSON：" + str, e);
        }
    }

}
