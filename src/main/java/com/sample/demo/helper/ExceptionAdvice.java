package com.sample.demo.helper;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionAdvice {

	@Value("${drees.stacktrace}")
	boolean stackTrace;

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse<List<StackTraceElement>> processAllError(Exception ex) {
		List<StackTraceElement> ele = null;

		if (stackTrace == true) {
			ele = Arrays.asList(ex.getStackTrace());
		}

		ErrorResponse<List<StackTraceElement>> response = new ErrorResponse<>(ele, ex.getMessage());
		return response;
	}
	
    @ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse<String> processNotFound(Exception ex) {
	

		ErrorResponse<String> response = new ErrorResponse<>("Page not found!!!!", ex.getMessage());
		return response;
	}
	
}