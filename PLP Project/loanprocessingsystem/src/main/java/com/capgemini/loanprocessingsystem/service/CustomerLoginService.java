package com.capgemini.loanprocessingsystem.service;

import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;

public interface CustomerLoginService {

	public boolean addCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException;
	public boolean deleteCustomerLoginData(String username) throws CustomException;
	public boolean updateCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException;	
	public  CustomerLoginDetails loginSingleUserCustomer(CustomerLoginDetails loginDetails)throws CustomException;
		
}//end of servcie
