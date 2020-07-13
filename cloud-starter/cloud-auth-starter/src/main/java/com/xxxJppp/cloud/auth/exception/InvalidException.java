package com.xxxJppp.cloud.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xxxJppp.cloud.auth.serializer.BaseAuth2ExceptionSerializer;

/**
 * @author
 */
@JsonSerialize(using = BaseAuth2ExceptionSerializer.class)
public class InvalidException extends BaseAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
