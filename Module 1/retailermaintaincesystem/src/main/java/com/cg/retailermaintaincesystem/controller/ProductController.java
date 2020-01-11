package com.cg.retailermaintaincesystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.retailermaintaincesystem.dto.ProductBean;
import com.cg.retailermaintaincesystem.dto.UserResponse;
import com.cg.retailermaintaincesystem.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping(path = "/view-product", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse viewProduct(@RequestParam("id") int productId) {
		UserResponse response = new UserResponse();
		ProductBean product = service.getProduct(productId);
		if (product != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product found");
			response.setProduct(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product id does not exist");
		}
		return response;
	}

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addProduct(@RequestBody ProductBean product) {
		UserResponse response = new UserResponse();
		if (service.addProduct(product)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product with same name already exists");
		}
		return response;
	}
}
