package com.retailservice.product.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.retailservice.product.exception.ExceptionMessage;
import com.retailservice.product.exception.ProductNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler 
						extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {ProductNotFoundException.class})
	public final ResponseEntity<Object> handleProductNotFoundException(Exception ex, WebRequest request) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		ExceptionMessage message = new ExceptionMessage(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public final ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		ExceptionMessage message = new ExceptionMessage(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
