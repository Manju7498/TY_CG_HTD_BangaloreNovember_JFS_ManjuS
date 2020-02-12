package com.capgemini.loanprocessingsystem.dao;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;

public interface CustomerLoginDao {
	public boolean addCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException;

	public boolean deleteCustomerLoginData(String username) throws CustomException;

	public boolean updateCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException;

	public CustomerLoginDetails loginSingleUserCustomer(CustomerLoginDetails loginDetails) throws CustomException;
}