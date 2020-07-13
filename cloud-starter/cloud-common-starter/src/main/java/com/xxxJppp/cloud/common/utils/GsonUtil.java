package com.xxxJppp.cloud.common.utils;

import com.google.gson.*;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * GsonUtil
 *
 * @author xxxJppp
 * @date 2020/6/2 16:36
 */
@UtilityClass
public class GsonUtil {

    public String toGson(Object src) {
        Gson gson = gson();
        return gson.toJson(src);
    }

    public Gson gson() {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls()
                .setLongSerializationPolicy(LongSerializationPolicy.STRING)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter())
                .serializeNulls()
                .create();

    }

    public static class LocalDateAdapter implements JsonSerializer<LocalDateTime> {
        @Override
        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }

}
