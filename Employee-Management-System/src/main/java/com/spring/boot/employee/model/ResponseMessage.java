package com.spring.boot.employee.model;

public class ResponseMessage {

	private Integer statusCode;

	private String message;

	private Long timeStamp;

	public ResponseMessage() {
		
	}

	public ResponseMessage(Integer statusCode, String message, Long timeStamp) {
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
