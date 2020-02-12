
package com.capgemini.loanprocessingsystem.controller;

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

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.LoanDetails;
import com.capgemini.loanprocessingsystem.dto.LoanDetailsResponse;
import com.capgemini.loanprocessingsystem.service.LoanDetailsService;
@CrossOrigin
@RestController
public class LoanDetailsController {
	@Autowired
	LoanDetailsService loandetailsservice;

	@PostMapping(path = "/addLoanDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDetailsResponse addLoanDetail(@RequestBody LoanDetails loanDetail) {
		LoanDetailsResponse loanDetailresponse = new LoanDetailsResponse();
		try {
			if (loandetailsservice.addLoanDetail(loanDetail)) {
				loanDetailresponse.setStatusCode(200);
				loanDetailresponse.setMessage("Successfull");
				loanDetailresponse.setDescription("Loan Details Added Successfully");
			}
		} catch (CustomException e) {
			loanDetailresponse.setStatusCode(404);
			loanDetailresponse.setMessage("faliue");
			loanDetailresponse.setDescription("Unable to Add the Loan details Please try again");
			e.printStackTrace();
		}
		return loanDetailresponse;
	}

	@DeleteMapping(path = "/deleteLoanDetails/{loandetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDetailsResponse deleteLoanDetails(@PathVariable("loandetailsId") int loandetailsId) {
		LoanDetailsResponse loandetailsResponse = new LoanDetailsResponse();
		try {
			if (loandetailsservice.deleteLoanDetail(loandetailsId)) {
				loandetailsResponse.setStatusCode(202);
				loandetailsResponse.setMessage("Sucess");
				loandetailsResponse.setDescription("Loan Detail Deleted");
			} else {
				loandetailsResponse.setStatusCode(404);
				loandetailsResponse.setMessage("failure");
				loandetailsResponse.setDescription("Unable to Process The request");
			}
		} catch (CustomException e) {
			loandetailsResponse.setStatusCode(404);
			loandetailsResponse.setMessage("failure");
			loandetailsResponse.setDescription("Unable to Process The request");
		}
		return loandetailsResponse;
	}

	@GetMapping(path = "/getAllLoanDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDetailsResponse getAllLoanDetails() {
		LoanDetailsResponse loanDetailsResponse = new LoanDetailsResponse();
		List<LoanDetails> loanDetailsList;
		try {
			loanDetailsList = loandetailsservice.getAllLoanDetails();
			if (loanDetailsList.size() == 0) {
				loanDetailsResponse.setStatusCode(404);
				loanDetailsResponse.setMessage("faliue");
				loanDetailsResponse.setDescription("Id Does Not Exist");
			} else {
				loanDetailsResponse.setStatusCode(202);
				loanDetailsResponse.setMessage("Successfull");
				loanDetailsResponse.setDescription("Loan details Found credential");
				loanDetailsResponse.setLoanbean(loanDetailsList);
			}
		} catch (CustomException e) {
			loanDetailsResponse.setStatusCode(404);
			loanDetailsResponse.setMessage("Faliue");
			loanDetailsResponse.setDescription("Unable to Find The Loan Details Please try Again");
			e.printStackTrace();
		}

		return loanDetailsResponse;
	}

	@PutMapping(path = "/updateLoanDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDetailsResponse updateLoan(@RequestBody LoanDetails loanDetails) {
		LoanDetailsResponse loannResponse = new LoanDetailsResponse();

		try {
			if (loandetailsservice.updateLoanDetail(loanDetails)) {
				loannResponse.setStatusCode(202);
				loannResponse.setMessage("success");
				loannResponse.setDescription("Customer updated succcessfully");
			} else {
				loannResponse.setStatusCode(404);
				loannResponse.setMessage("failure");
				loannResponse.setDescription("Customer update failure");
			}
		} catch (CustomException e) {
			loannResponse.setStatusCode(404);
			loannResponse.setMessage("failure");
			loannResponse.setDescription("Customer update failure");
			e.printStackTrace();
		}
		return loannResponse;
	}


}//end of class