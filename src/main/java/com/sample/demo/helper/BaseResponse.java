package com.sample.demo.helper;

import org.springframework.http.HttpStatus;

public class BaseResponse<T> {

	int statusCode = HttpStatus.OK.value();
	String message = "Success";
	T data = null;
	
	public static BaseResponse<String> getErrorResponse(String message) {
		BaseResponse<String> errorResponse = new BaseResponse<>();
		errorResponse.message = message;
		errorResponse.statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
		return errorResponse;
	}

	@Override
	public String toString() {
		return "{statusCode=" + statusCode + ", message=" + message + ", data=" + data + "}";
	}
	
}
