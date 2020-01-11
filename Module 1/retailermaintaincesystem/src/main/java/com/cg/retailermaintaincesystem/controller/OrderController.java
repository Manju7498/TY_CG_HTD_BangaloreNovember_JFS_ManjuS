package com.cg.retailermaintaincesystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.retailermaintaincesystem.dto.OrderBean;
import com.cg.retailermaintaincesystem.dto.ProductBean;
import com.cg.retailermaintaincesystem.dto.UserResponse;
import com.cg.retailermaintaincesystem.service.OrderService;
import com.cg.retailermaintaincesystem.service.ProductService;

@RestController
public class OrderController {
	@Autowired
	OrderService service;

	@GetMapping(path = "/view-order", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse viewProduct(@RequestParam("id") int orderId) {
		UserResponse response = new UserResponse();
		OrderBean order = service.getOrder(orderId);
		if (order != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order found");
			response.setOrder(Arrays.asList(order));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Order id does not exist");
		}
		return response;
	}

	@PostMapping(path = "/add-order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addOrder(@RequestBody OrderBean order) {
		UserResponse response = new UserResponse();
		if (service.addOrder(order)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Order with same id already exists");
		}
		return response;
	}
}
