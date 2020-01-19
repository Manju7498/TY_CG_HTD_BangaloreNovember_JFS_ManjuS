package com.cg.forestmanagementspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.forestmanagementspringrest.dto.ForestryResponse;
import com.cg.forestmanagementspringrest.exceptions.ForestryException;

@RestControllerAdvice
public class ForestryControllerAdvice {
	@ExceptionHandler(ForestryException.class)
	public ForestryResponse handleEmployeeException(ForestryResponse e) {
		ForestryResponse response = new ForestryResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
