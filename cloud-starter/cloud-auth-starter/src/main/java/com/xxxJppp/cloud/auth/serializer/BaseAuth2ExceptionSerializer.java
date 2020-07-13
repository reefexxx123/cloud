package com.xxxJppp.cloud.auth.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.xxxJppp.cloud.auth.exception.BaseAuth2Exception;
import com.xxxJppp.cloud.common.enums.ResultEnum;
import com.xxxJppp.cloud.common.utils.ResponseUtil;
import lombok.SneakyThrows;

import java.util.Map;

/**
 * @author
 * <p>
 * OAuth2 异常格式化
 */
public class BaseAuth2ExceptionSerializer extends StdSerializer<BaseAuth2Exception> {
	public BaseAuth2ExceptionSerializer() {
		super(BaseAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(BaseAuth2Exception e, JsonGenerator jsonGenerator, SerializerProvider provider) {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("code", ResultEnum.UNAUTHORIZED.getCode());
		jsonGenerator.writeStringField("message",  ResultEnum.UNAUTHORIZED.getMessage());
		jsonGenerator.writeObjectField("data", e.getMessage());
		if (e.getAdditionalInformation() != null) {
			for (Map.Entry<String, String> entry : e.getAdditionalInformation().entrySet()) {
				jsonGenerator.writeStringField(entry.getKey(), entry.getValue());
			}
		}
		jsonGenerator.writeEndObject();
	}
}
