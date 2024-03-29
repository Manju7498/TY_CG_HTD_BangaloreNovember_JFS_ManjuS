package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.dto.LoanStatus;
import com.capgemini.loanprocessingsystem.exception.CustomException;

public interface LoanStatusServcie {
	public boolean addLoanStatusDetails(LoanStatus loanstatus)throws CustomException;
	public boolean deleteLoanStatusDetails(int statusId ) throws CustomException;
	public List<LoanStatus> getAllLoanstatus() throws CustomException;
	public boolean updateLoanStatus(LoanStatus loanstatus) throws CustomException;
	public LoanStatus getTheStatusById(int statusId) throws CustomException;
	public LoanStatus getAll() throws CustomException;
	public boolean addCustomerLogin(CustomerLoginDetails customerLogin);
}
