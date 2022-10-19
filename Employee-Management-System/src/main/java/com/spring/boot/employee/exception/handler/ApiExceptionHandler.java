package com.spring.boot.employee.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.boot.employee.exception.InvalidRequestException;
import com.spring.boot.employee.model.ResponseMessage;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleError(InvalidRequestException exception) {
		ResponseMessage error = new ResponseMessage(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleError(Exception exception) {
		ResponseMessage error = new ResponseMessage(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
