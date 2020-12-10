package com.dto;

public class ResponseDTO {

	private String message;
	private Object data;
	public ResponseDTO(String string, Object data) {
		this.message = string;
		this.data = data;
	}
	
	public ResponseDTO(String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
