package com.ClientReq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ClientReq.exception.ClientException;

@RestControllerAdvice
public class ClientControllerAdvice {
	
	@ExceptionHandler(ClientException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String ClientException(ClientException e) {
		return e.getMessage();

	}
}