package com.sample.demo.helper;

//import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO<T> implements java.io.Serializable {
	
private static final long serialVersionUID = 1L;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;
    private String message;
    public ErrorDTO(T body, String message) {
        this.body = body;
        this.message = message;
    }
    public T getBody() {
        return body;
    }
    public void setBody(T body) {
        this.body = body;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}