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

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.InterviewInfo;
import com.capgemini.loanprocessingsystem.dto.InterviewInfoResponse;
import com.capgemini.loanprocessingsystem.service.InterviewInfoService;

@CrossOrigin
@RestController
public class InterviewInfoController {
	@Autowired
	private InterviewInfoService interviewInfoService;
	// adding interview info
		@PostMapping(path = "/addInterview", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public InterviewInfoResponse addInterviewInfo(@RequestBody InterviewInfo interviewInfo) {
			InterviewInfoResponse interviewInfoResponse = new InterviewInfoResponse();
			try {
				if (interviewInfoService.addInterviewInfo(interviewInfo) != false) {
					interviewInfoResponse.setStatusCode(200);
					interviewInfoResponse.setMessage("Successfull");
					interviewInfoResponse.setDescription("Loan Details Added Successfully");
				} else {
					interviewInfoResponse.setStatusCode(404);
					interviewInfoResponse.setMessage("faliue");
					interviewInfoResponse.setDescription("Unable to Add the Loan details Please try again");
				}
			} catch (CustomException e) {
				interviewInfoResponse.setStatusCode(404);
				interviewInfoResponse.setMessage("faliue");
				interviewInfoResponse.setDescription("Unable to Add the Loan details Please try again");
			}
			return interviewInfoResponse;
		}

		// updating interviewInfo
		@PutMapping(path = "/modifyInterviewInfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public InterviewInfoResponse updateInterviewInfo(@RequestBody InterviewInfo interview) {
			InterviewInfoResponse response = new InterviewInfoResponse();
			try {
				if (interviewInfoService.updateInterviewInfo(interview)) {
					response.setStatusCode(200);
					response.setMessage("Success !!");
					response.setDescription("Customer data updated Successfully");
				} else {
					response.setStatusCode(444);
					response.setMessage("Failure");
					response.setDescription(
							"Failed To Update The Id CustomerID that You Have Entered Is Unable to find in Customer DataBase"
									+ "Please try Again With Correct CustomerID");
				}
			} catch (CustomException e) {
				response.setStatusCode(404);
				response.setMessage("Failure");
				response.setDescription("Failed To Update");
				e.printStackTrace();
			}
			return response;
		}

		// delete for interviewInfo
		@DeleteMapping(path = "/deleteInterviewInfo/{slNo}", produces = MediaType.APPLICATION_JSON_VALUE)
		public InterviewInfoResponse deleteInterviewInfo(@PathVariable int slNo) {
			InterviewInfoResponse response = new InterviewInfoResponse();
			try {
				if (interviewInfoService.deleteInterviewInfo(slNo)) {
					// Deletion successfully
					response.setStatusCode(200);
					response.setMessage("Success");
					response.setDescription("InterViewInfo data deleted Successfully !!");
				} else {
					// Deletion unsuccessful Unsuccessfully
					response.setStatusCode(444);
					response.setMessage("Failure !!");
					response.setDescription("The Data is Unable to Delete Please try again");
				}
			} catch (CustomException e) {
				response.setStatusCode(404);
				response.setMessage("Failure !!");
				response.setMessage("Unable to Process the request Please try again ");
				e.printStackTrace();
			}
			return response;
		}// end of delete interview Info

		@PostMapping(path = "/viewSingleInterviewInfo/{slNo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public InterviewInfoResponse viewSingleDetail(@PathVariable int slNo) {
			InterviewInfo interviewDetailsDto;
			InterviewInfoResponse response = new InterviewInfoResponse();
			try {
				interviewDetailsDto = interviewInfoService.getInterviewInfoDetailsById(slNo);
				if (interviewDetailsDto != null) {
					response.setStatusCode(201);
					response.setMessage("Success");
					response.setDescription("Customer data found");
					response.setBean(Arrays.asList(interviewDetailsDto));
				} else {
					response.setStatusCode(444);
					response.setMessage("failure");
					response.setDescription("Invalid Customer Id try with correct one");
				}
			} catch (CustomException e) {
				response.setStatusCode(404);
				response.setMessage("failure");
				response.setDescription("Invalid ID or Data Not Please try again With Correct Id");
				e.printStackTrace();
			}
			return response;
		}// end of add User

		@GetMapping(path = "/viewallInterviewInfo", produces = MediaType.APPLICATION_JSON_VALUE)
		public InterviewInfoResponse viewallInterviewInfo() {
			InterviewInfoResponse response = new InterviewInfoResponse();
			List<InterviewInfo> result;
			try {
				result = interviewInfoService.getAllInterviewInfoDetails();
				if (!result.isEmpty()) {
					response.setStatusCode(200);
					response.setMessage("Success ");
					response.setDescription("Customer details are");
					response.setBean(result);
				} else {
					response.setStatusCode(444);
					response.setMessage("Failure !!");
					response.setDescription("customers data not found Please try again");
				}
			} catch (CustomException e) {
				response.setStatusCode(404);
				response.setMessage("Failure !!");
				response.setDescription("Customers data not found");
				e.printStackTrace();
			}
			return response;
		}// end of view all Customer


	

}//end of class