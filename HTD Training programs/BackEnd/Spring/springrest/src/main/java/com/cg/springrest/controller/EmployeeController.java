package com.cg.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springrest.dto.EmployeeBean;
import com.cg.springrest.dto.EmployeeResponse;
import com.cg.springrest.service.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping(path="/auth",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponse auth(@RequestBody EmployeeBean bean) {
		EmployeeBean employeeBean= service.auth(bean.getEmployeeEmail(),bean.getPassword());
		EmployeeResponse response=new EmployeeResponse();
		if(employeeBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee found for credentials");
			response.setBean(Arrays.asList(employeeBean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Credentials Invalid");
		}
		return response;
	}
	@PostMapping(path="/register",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponse register(@RequestBody EmployeeBean bean) {
		EmployeeResponse response=new EmployeeResponse();
		if(service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee registered");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Email already exists");
		}
		return response;
	}
	@GetMapping(path="/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse searchEmployee(@RequestParam("key") String key) {
		EmployeeResponse response=new EmployeeResponse();
		List<EmployeeBean> beans=service.getEmployees(key);
		if(!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Data  found");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not found");
		}
		return response;
	}
	@PutMapping(path="/change-password",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponse changePassword(@RequestBody EmployeeBean bean) {
		EmployeeResponse response=new EmployeeResponse();
		if(service.changePassword(bean.getEmployeeId(),bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Data changed");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data  is not changed");
		}
		return response;
	}
	@DeleteMapping(path="/delete/{employeeId}")
	public EmployeeResponse deleteEmployee(@PathVariable int employeeId) {
	EmployeeResponse response=new EmployeeResponse();
	service.deleteEmployee(employeeId);
		response.setStatusCode(201); 
		response.setMessage("success");
		response.setDescription("Employee details deleted");
		return response;
	}
}










