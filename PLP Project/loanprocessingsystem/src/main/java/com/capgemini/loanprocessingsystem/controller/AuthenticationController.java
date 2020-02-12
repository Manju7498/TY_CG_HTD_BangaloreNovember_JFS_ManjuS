package com.capgemini.loanprocessingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.AuthenticationDetails;
import com.capgemini.loanprocessingsystem.dto.AuthenticationResponse;
import com.capgemini.loanprocessingsystem.service.AdminService;

@CrossOrigin
@RestController
public class AuthenticationController {
	
	@Autowired
	private AdminService adminservice;
	
	@PostMapping(path = "/addEmployeeDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse addClient(@RequestBody AuthenticationDetails authentication) {
		AuthenticationResponse response = new AuthenticationResponse();
		try {
			if (adminservice.addEmployeeDetails(authentication)) {
				// Added successfully
				response.setStatusCode(200);
				response.setMessage("Success !!");
				response.setDescription("User added succefully");
			}
		} catch (CustomException e) {
			// Added Unsuccessfully
			response.setStatusCode(404);
			response.setMessage("Failure !!");
			response.setMessage("User Name that you have entered already exist, Please try with different username");
		}
		return response;
	}// end of add adddetails

	@DeleteMapping(path = "/deleteClientDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse deleteUser(@RequestBody AuthenticationDetails authentication) {
		AuthenticationResponse response = new AuthenticationResponse();
		try {
			if (adminservice.deleteEmployeeDetails(authentication)) {
				// Added successfully
				response.setStatusCode(200);
				response.setMessage("User  data deleated succefully");
				response.setDescription("User deleated succefully");
			}
		} catch (CustomException e) {
			response.setStatusCode(404);
			response.setMessage("Incorrect login Creditianls Unable to Proecess your request to Delete");
			response.setDescription("Data is Not Deleted");
		}
		return response;
	}

	// end of delete User
//	@PutMapping(path = "/modifEmployeeDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public AuthenticationResponse modifyUser(@RequestBody AuthenticationDetails authentication) {
//		AuthenticationResponse response = new AuthenticationResponse();
//		try {
//			if (adminservice.modifyEmployeeDetails(authentication)) {
//				// Added successfully
//				response.setStatusCode(200);
//				response.setMessage("Success !!");
//				response.setDescription("User adat modified successfully");
//			} 
//		} catch (CustomException e) {
//		//unable to update
//						response.setStatusCode(404);
//						response.setMessage("Failure !!");
//						response.setDescription("Login creditainls didnt matched");
//			e.printStackTrace();
//		}
//		return response;
//	}// end of add Client
	
	
	
	
}//end of class