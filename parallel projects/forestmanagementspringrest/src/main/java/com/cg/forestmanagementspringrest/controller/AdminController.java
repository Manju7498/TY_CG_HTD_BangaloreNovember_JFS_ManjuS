package com.cg.forestmanagementspringrest.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.forestmanagementspringrest.dto.AdminBean;
import com.cg.forestmanagementspringrest.dto.ForestryResponse;
import com.cg.forestmanagementspringrest.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;

	@PostMapping(path = "/admin-login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse auth(@RequestBody AdminBean bean) {
		ForestryResponse response = new ForestryResponse();
		AdminBean adminBean = service.login(bean);
		if (adminBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Admin logged in successfully");
			response.setAdmin(Arrays.asList(adminBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Invalid password");
		}
		return response;
	}

	@PostMapping(path = "/admin-register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse register(@RequestBody AdminBean bean) {
		ForestryResponse response = new ForestryResponse();
		if (service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Admin registered");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Admin already registered");
		}
		return response;
	}
}
