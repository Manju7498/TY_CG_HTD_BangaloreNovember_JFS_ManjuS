package com.capgemini.loanprocessingsystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.dto.CustomerLoginResponse;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.service.CustomerLoginService;

@CrossOrigin
@RestController
public class CustomerLoginController {
	@Autowired
	CustomerLoginService customerloginservcie;

	@PostMapping(path = "/userAuthentication", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerLoginResponse userAuthentication(@RequestBody CustomerLoginDetails loginDetails)
			throws CustomException {
		CustomerLoginDetails authenticationDetailsDto = customerloginservcie.loginSingleUserCustomer(loginDetails);
		CustomerLoginResponse response = new CustomerLoginResponse();
		if (authenticationDetailsDto != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription(
					"Congratulations, your loan amount have been sanctioned, and the premium amount to be paid per month will be sent to registered mobile no!!!");
			response.getResponsebean(Arrays.asList(authenticationDetailsDto));
		} else {
			response.setStatusCode(404);
			response.setMessage("failure");
			response.setDescription(
					"Sorry, loan have not been sanctioned , as the credit score after interview does'nt match the banck creteria to approve loan!!!");
		}
		return response;
	}

	@PostMapping(path = "/addlogininfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerLoginResponse addLogin(@RequestBody CustomerLoginDetails customerlogin) {
		CustomerLoginResponse response = new CustomerLoginResponse();
		try {
			if (customerloginservcie.addCustomerLoginData(customerlogin)) {
				// Added successfully
				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDescription("Customer data added succefully");
			} else {
				// Added Unsuccessfully
				response.setStatusCode(404);
				response.setMessage("Failure");
				response.setMessage("Unable to Process The Request");
			}
		} catch (CustomException e) {
			response.setStatusCode(444);
			response.setMessage("Failure");
			response.setMessage("Unable to Add The Details");
			e.printStackTrace();
		}
		return response;
	}

	@PutMapping(path = "/modifylogindetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerLoginResponse modifyLoginDetails(@RequestBody CustomerLoginDetails customerlogin) {
		CustomerLoginResponse response = new CustomerLoginResponse();
		try {
			if (customerloginservcie.updateCustomerLoginData(customerlogin)) {
				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDescription("Customer data updated Successfully");
			} else {
				response.setStatusCode(444);
				response.setMessage("Failure !!");
				response.setMessage("unable to Process the request");
			}
		} catch (CustomException e) {
			response.setStatusCode(404);
			response.setMessage("Failure !!");
			response.setMessage("unable to Process the request  Please try Again");
			e.printStackTrace();
		}
		return response;
	}

	@DeleteMapping(path = "/deletelogindetails/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerLoginResponse deleteCustomer(@PathVariable("username") String username) {
		CustomerLoginResponse response = new CustomerLoginResponse();
		try {
			if (customerloginservcie.deleteCustomerLoginData(username)) {
				// Deletion successfully
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Loan  data deleted Successfully !!");
			} else {
				// Deletion unsuccessful Unsuccessfully
				response.setStatusCode(444);
				response.setMessage("Failure !!");
				response.setMessage("unable to Process the request");
			}
		} catch (CustomException e) {
//			response.setStatusCode(444);
//			response.setMessage("Failure !!");
//			response.setMessage("unable to Process the request");
			e.printStackTrace();
		}
		return response;
	}// end of delete customer

}// end of class
