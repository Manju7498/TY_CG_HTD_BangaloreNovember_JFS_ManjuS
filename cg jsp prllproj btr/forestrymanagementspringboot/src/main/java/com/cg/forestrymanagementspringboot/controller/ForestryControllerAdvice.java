package com.cg.forestrymanagementspringboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.forestrymanagementspringboot.dto.ForestryResponse;
import com.cg.forestrymanagementspringboot.exceptions.ForestryExceptions;

@RestControllerAdvice
public class ForestryControllerAdvice {
	@ExceptionHandler(ForestryExceptions.class)
	public ForestryResponse handleEmployeeException(ForestryResponse e) {
		ForestryResponse response = new ForestryResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
