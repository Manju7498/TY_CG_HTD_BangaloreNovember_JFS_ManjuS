package com.capgemini.loanprocessingsystem.dao;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.AuthenticationDetails;

public interface AdminDao {

	public boolean addEmployeeDetails(AuthenticationDetails authentication) throws CustomException;

	// public boolean modifyEmployeeDetails(AuthenticationDetails authentication)
	// throws CustomException;
	public boolean deleteEmployeeDetails(AuthenticationDetails authentication) throws CustomException;
}
