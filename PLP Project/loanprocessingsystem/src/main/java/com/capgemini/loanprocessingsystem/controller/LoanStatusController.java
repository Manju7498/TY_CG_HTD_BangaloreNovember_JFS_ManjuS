package com.capgemini.loanprocessingsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dao.CustomerDetailsDao;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;
import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.dto.LoanStatus;
import com.capgemini.loanprocessingsystem.dto.LoanStatusResponse;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.service.LoanStatusServcie;

@CrossOrigin
@RestController
public class LoanStatusController {
	@Autowired
	LoanStatusServcie loanststusService;

	@Autowired
	CustomerDetailsDao customerdao;

	CustomerDetails details = new CustomerDetails();

	CustomerLoginDetails custLogin = new CustomerLoginDetails();

	@PostMapping(path = "/addLoanStatus", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanStatusResponse addCustomer(@RequestBody LoanStatus loanStatus) {
		LoanStatusResponse response = new LoanStatusResponse();

		try {
			if (loanststusService.addLoanStatusDetails(loanStatus)) {
				// Added successfully
				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDesription("Loan status details added succefully");
				CustomerDetails details = customerdao.getCustomerDetailsById(loanStatus.getCustId());
				if (loanStatus.getApprovalStatus().equalsIgnoreCase("approved")
						|| loanStatus.getApprovalStatus().equalsIgnoreCase("loan approved")
						|| loanStatus.getApprovalStatus().equalsIgnoreCase("loan approved")
						|| loanStatus.getApprovalStatus().equalsIgnoreCase("loan not approved")) {
					custLogin.setUsername(details.getCustomerName().toLowerCase() + "@lap.com");
					custLogin.setPassword(details.getCustomerName().toLowerCase());
					custLogin.setStatusReport(loanStatus.getApprovalStatus());
					loanststusService.addCustomerLogin(custLogin);
				}

			} else {
				// Added Unsuccessfully
				response.setStatusCode(404);
				response.setMessage("Failure");
				response.setMessage("Unable to Process The Request");
			}
		} catch (CustomException e) {
			response.setStatusCode(444);
			response.setMessage("Failure");
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}// and here loanID is not taking

	@PutMapping(path = "/modifyloandetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanStatusResponse modifyLoanStatus(@RequestBody LoanStatus loanstatus) {
		LoanStatusResponse response = new LoanStatusResponse();
		try {
			if (loanststusService.updateLoanStatus(loanstatus)) {

				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDesription("Customer data updated Successfully");

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

	// view Single details
	@PostMapping(path = "/viewsingleloandetails/{statusId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoanStatusResponse viewSingleDetail(@PathVariable int statusId) {
		LoanStatus getLoanStatus;
		LoanStatusResponse response = new LoanStatusResponse();
		try {
			getLoanStatus = loanststusService.getTheStatusById(statusId);
			if (getLoanStatus != null) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDesription("Customer data found");
				response.setLoanbean(Arrays.asList(getLoanStatus));
			} else {
				response.setStatusCode(444);
				response.setMessage("failure");
				response.setDesription("Invalid Customer Id try with correct one");
			}
		} catch (CustomException e) {
			response.setStatusCode(404);
			response.setMessage("failure");
			response.setDesription("Invalid ID or Data Not Please try again With Correct Id");
			e.printStackTrace();
		}
		return response;

	}// end of add User

	@GetMapping(path = "/viewallloaninfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanStatusResponse viewallLoanDetails() {
		LoanStatusResponse response = new LoanStatusResponse();
		List<LoanStatus> result;
		try {
			result = loanststusService.getAllLoanstatus();
			if (!result.isEmpty()) {
				response.setStatusCode(200);
				response.setMessage("Success ");
				response.setDesription("Customer details are");
				response.setLoanbean(result);
			} else {
				response.setStatusCode(444);
				response.setMessage("Failure !!");
				response.setDesription("customers data not found Please try again");
			}
		} catch (Exception e) {
			response.setStatusCode(404);
			response.setMessage("Failure !!");
			response.setDesription("Loan Data Is Not Found");
			e.printStackTrace();
		}

		return response;
	}// end of view all Customer

}// end of class
