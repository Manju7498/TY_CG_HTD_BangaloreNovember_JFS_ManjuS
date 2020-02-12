package com.capgemini.loanprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDetailsDao;
import com.capgemini.loanprocessingsystem.dao.CustomerLoginDao;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;
import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;
@Service
public class CustomerLoginServcieImpl implements CustomerLoginService {

	@Autowired
	CustomerLoginDao login;
	

	@Autowired 
    CustomerDetailsDao customerdao;
	
	CustomerDetails details= new CustomerDetails();
	
	@Override
	public boolean addCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException {

		return login.addCustomerLoginData(customerlogin);
	}

	@Override
	public boolean deleteCustomerLoginData(String username) throws CustomException {	
		return login.deleteCustomerLoginData(username);
	}

	@Override
	public boolean updateCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException {
		return login.updateCustomerLoginData(customerlogin);
	}

	@Override
	public CustomerLoginDetails loginSingleUserCustomer(CustomerLoginDetails loginDetails) throws CustomException {
		return login.loginSingleUserCustomer(loginDetails);
	}


}
