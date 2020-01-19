package com.cg.forestmanagementspringrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.forestmanagementspringrest.dto.ForestryResponse;
import com.cg.forestmanagementspringrest.dto.ProductBean;
import com.cg.forestmanagementspringrest.service.ProductService;

@RestController
public class ProductController {
			@Autowired
			ProductService service;

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ForestryResponse addProduct(@RequestBody ProductBean product) {
				ForestryResponse response = new ForestryResponse();
				if (service.addProduct(product)) {
					response.setStatusCode(201);
					response.setMessage("Success");
					response.setDescription("product added");
				} else {
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription("product with same id already exists");
				}
				return response;
			}
			@DeleteMapping(path = "/delete-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
			public ForestryResponse deleteProduct(@PathVariable("productId") int productId) {
				ForestryResponse response = new ForestryResponse();
				if (service.deleteProduct(productId)) {
					response.setStatusCode(201);
					response.setMessage("Success");
					response.setDescription("product deleted");
				} else {
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription("product not found");
				}
				return response;
			}
			@GetMapping(path = "/view-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
			public ForestryResponse viewProduct(@PathVariable("productId") int productId) {
				ForestryResponse response = new ForestryResponse();
				ProductBean product = service.getProduct(productId);
				if (product != null) {
					response.setStatusCode(201);
					response.setMessage("Success");
					response.setDescription("Product found");
					response.setProduct(Arrays.asList(product));
				} else {
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription("Product Id does not exist");
				}
				return response;
			}
			@GetMapping(path = "/view-allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
			public ForestryResponse viewAllProducts() {
				ForestryResponse response = new ForestryResponse();
				List<ProductBean> list = service.getAllProducts();
				if (list.size() != 0) {
					response.setStatusCode(201);
					response.setMessage("Success");
					response.setDescription("products found");
					response.setProduct(list);
				} else {
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription("No data");
				}
				return response;

			}
			@PutMapping(path="/update-product",produces=MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
			public  ForestryResponse updateProduct (@RequestBody ProductBean bean) {
				ForestryResponse response=new ForestryResponse();
				if(service.updateProduct(bean)) {
					response.setStatusCode(201);
					response.setMessage("success");
					response.setDescription("Product updated");
				}else {
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription("Product  is not updated");
				}
				return response;
			}


}
