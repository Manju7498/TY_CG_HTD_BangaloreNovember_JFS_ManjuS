package com.cg.forestmanagementspringrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.forestmanagementspringrest.dto.CustomerBean;
import com.cg.forestmanagementspringrest.dto.ForestryResponse;
import com.cg.forestmanagementspringrest.service.CustomerService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
public class CustomerController {
	@Autowired
	CustomerService service;

	@PostMapping(path = "/add-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse addCustomer(@RequestBody CustomerBean customer) {
		ForestryResponse response = new ForestryResponse();
		if (service.addCustomer(customer)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("customer added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("customer with same id already exists");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse deleteCustomer(@PathVariable("customerId") String customerId) {
		ForestryResponse response = new ForestryResponse();
		if (service.deleteCustomer(customerId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("customer deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("customer not found");
		}
		return response;
	}

	@GetMapping(path = "/view-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse viewCustomer(@PathVariable("customerId") String customerId) {
		ForestryResponse response = new ForestryResponse();
		CustomerBean customer = service.getCustomer(customerId);
		if (customer != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer found");
			response.setCustomer(Arrays.asList(customer));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Customer Id does not exist");
		}
		return response;
	}

	@GetMapping(path = "/view-allCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse viewAllCustomers() {
		ForestryResponse response = new ForestryResponse();
		List<CustomerBean> list = service.getAllCustomers();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customers found");
			response.setCustomer(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}

	@PutMapping(path = "/update-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse updateCustomer(@PathVariable("customerId") String customerId, @RequestBody CustomerBean bean) {
		ForestryResponse response = new ForestryResponse();
		if (service.updateCustomer(customerId,bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Customer updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Customer is not updated");
		}
		return response;
	}

}
