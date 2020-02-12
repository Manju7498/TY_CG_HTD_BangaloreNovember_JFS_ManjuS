package com.capgemini.loanprocessingsystem.controller;

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

import com.capgemini.loanprocessingsystem.dao.InterviewInfoDao;
import com.capgemini.loanprocessingsystem.dao.LoanStatusDao;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;
import com.capgemini.loanprocessingsystem.dto.CustomerDetailsResponse;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.service.CustomerDetailsService;
@CrossOrigin
@RestController
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService customerService;
	@Autowired
	InterviewInfoDao interviewinfodao;

	@Autowired
	LoanStatusDao loandao;

	@PostMapping(path = "/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailsResponse addCustomer(@RequestBody CustomerDetails customerDetails) {
		CustomerDetailsResponse response = new CustomerDetailsResponse();
		try {
			String userName = "not set";
			String pass = "not set";
			if (customerService.addCustomer(customerDetails)) {
//				String[] args = null;
//				
//			    String rd=RandomDateGenerator.main(args);

				// Added successfully
				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDescription("Customer Details Registered Sucessfully, interview is scheduled on "
						+ (customerDetails.getCustomerId() - 40) + "/02/2020"
						+ " login credentials will be sent to number " + customerDetails.getCustomerContactNo()
						+ " shortly, update the password within 45days...");

			}
		} catch (Exception e) {
			response.setStatusCode(404);
			response.setMessage("Failure");
			response.setDescription(e.getMessage());
			// e.printStackTrace();
		}
		return response;
	}// end of add Customer

	@PutMapping(path = "/modifyCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailsResponse updateCustomerDetails(@RequestBody CustomerDetails customerdetails) {
		CustomerDetailsResponse response = new CustomerDetailsResponse();
		try {
			if (customerService.updateCustomerDetails(customerdetails)) {
				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDescription("Customer data updated Successfully");
			} else {
				response.setStatusCode(404);
				response.setMessage("Failure !!");
				response.setDescription("unable to Process the request");
			}

		} catch (CustomException e) {
			response.setStatusCode(404);
			response.setMessage("Failure !!");
			response.setMessage("unable to Process the request");
			e.printStackTrace();
		}
		return response;
	}

	@DeleteMapping(path = "/deleteCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailsResponse deleteCustomer(@PathVariable("customerId") int id) {
		CustomerDetailsResponse response = new CustomerDetailsResponse();
		try {
			if (customerService.deleteCustomerDetails(id)) {
				// Deletion successfully
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Customer  data deleted Successfully !!");
			} else {
				// Deletion unsuccessful Unsuccessfully
				response.setStatusCode(444);
				response.setMessage("Failure !!");
				response.setMessage("unable to Process the request");
			}
		} catch (CustomException e) {
			response.setStatusCode(444);
			response.setMessage("Failure !!");
			response.setMessage("unable to Process the request");
		}
		return response;
	}// end of delete customer

	@GetMapping(path = "/getAllCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailsResponse viewallCustomer() {
		CustomerDetailsResponse response = new CustomerDetailsResponse();
		List<CustomerDetails> result;
		try {
			result = customerService.getAllCustomerDetails();
			if (!result.isEmpty()) {
				response.setStatusCode(200);
				response.setMessage("Success ");
				response.setDescription("Customer details are");
				response.setBean(result);
			} else {
				response.setStatusCode(404);
				response.setMessage("Failure !!");
				response.setDescription("customers data not found");
			}
		} catch (CustomException e) {
			response.setStatusCode(404);
			response.setMessage("Failure !!");
			response.setDescription("customers data not found");
			e.printStackTrace();
		}
		return response;
	}// end of view all Customer

	@PostMapping(path = "/viewSingleCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailsResponse viewSingleCustomer(@PathVariable("customerId") int customerId) {
		CustomerDetails customerDetails;
		CustomerDetailsResponse response = new CustomerDetailsResponse();
		try {
			customerDetails = customerService.getCustomerDetailsById(customerId);
			if (customerDetails != null) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Customer data found");
				response.setBean(Arrays.asList(customerDetails));
			} else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Invalid Customer Id try with correct one");
			}
		} catch (CustomException e) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Invalid Customer Id try with correct one");
			e.printStackTrace();
		}
		return response;
	}// end of add User

	
}//end of class