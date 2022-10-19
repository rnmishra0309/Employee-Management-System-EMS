package com.spring.boot.employee.exception;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = -5174764036945489824L;

	public InvalidRequestException(String message) {
		super(message);
	}

}
