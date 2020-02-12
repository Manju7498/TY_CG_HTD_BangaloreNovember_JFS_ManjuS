package com.capgemini.loanprocessingsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.loanprocessingsystem.dto.AuthenticationResponse;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@RestControllerAdvice
public class AdviceController {
	@ExceptionHandler(CustomException.class)
	public AuthenticationResponse handleAuthenticationException(CustomException e) {
		AuthenticationResponse response=new AuthenticationResponse();
		response.setStatusCode(501);
		response.setMessage(e.getMessage());	
		return response;
	}
}