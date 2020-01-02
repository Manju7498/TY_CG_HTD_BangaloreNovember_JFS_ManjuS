package com.cg.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.springboot.bean.EmployeeResponse;
import com.cg.springboot.exceptions.EmployeeException;

@RestControllerAdvice
public class EmployeeControlleradvice {
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse handleEmployeeException(EmployeeException e) {
		EmployeeResponse response=new EmployeeResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
