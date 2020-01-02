package com.cg.empspringboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.empspringboot.dto.EmployeeResponse;
import com.cg.empspringboot.exceptions.EmployeeException;

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
