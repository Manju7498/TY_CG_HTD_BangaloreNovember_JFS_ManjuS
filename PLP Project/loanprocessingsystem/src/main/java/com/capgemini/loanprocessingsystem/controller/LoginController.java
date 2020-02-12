package com.capgemini.loanprocessingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dto.LoanApplicationProcessingResponse;
import com.capgemini.loanprocessingsystem.dto.Login;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.service.LoginServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class LoginController {
	@Autowired
	private LoginServices service;
	
	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanApplicationProcessingResponse loginAdmin(@RequestBody Login credentials) {
		LoanApplicationProcessingResponse response = new LoanApplicationProcessingResponse();
		try {
			Login login = service.login(credentials);

			if (login != null) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Logged in");
				response.setLogin(login);
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Please check the admin credentials entered!!!");
			}
		} catch (CustomException e) {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription(e.getMessage());
		}

		return response;
	}

	@PostMapping(path = "/addaccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanApplicationProcessingResponse register(@RequestBody Login addAccount) {
		LoanApplicationProcessingResponse response = new LoanApplicationProcessingResponse();

		if (service.addAccount(addAccount)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Registered Successful...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Credentials Already Exists!!!");
		}
		return response;
	}

}
