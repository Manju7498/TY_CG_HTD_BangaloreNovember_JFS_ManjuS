package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;

public interface CustomerDetailsService {
	public boolean addCustomer(CustomerDetails customerDetails) throws CustomException;
	public List<CustomerDetails> getAllCustomerDetails() throws CustomException;
	public boolean deleteCustomerDetails(int custId) throws CustomException;
	public boolean updateCustomerDetails(CustomerDetails customerdetails) throws CustomException;
	public CustomerDetails getCustomerDetailsById(int customerId) throws CustomException;
	public boolean searchCustomer(int customerId);
}

