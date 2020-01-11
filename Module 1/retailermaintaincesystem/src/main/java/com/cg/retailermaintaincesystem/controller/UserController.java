package com.cg.retailermaintaincesystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.retailermaintaincesystem.dto.UserBean;
import com.cg.retailermaintaincesystem.dto.UserResponse;
import com.cg.retailermaintaincesystem.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping(path = "/user-login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse auth(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		UserBean userBean = service.login(bean);
		if (userBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("User logged in successfully");
			response.setUser(Arrays.asList(userBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Invalid password");
		}
		return response;
	}

	@PostMapping(path = "/user-register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		if (service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("User registered");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User already registered");
		}
		return response;
	}

	@PutMapping(path = "/update-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updatePassword(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		if (service.updatePassword(bean.getId(),bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Password updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("password  is not updated");
		}
		return response;
	}

}
