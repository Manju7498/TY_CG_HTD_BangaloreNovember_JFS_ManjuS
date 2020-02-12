package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.LoanDetails;

public interface LoanDetailsService {

	public boolean addLoanDetail(LoanDetails loandetail) throws CustomException;
	public boolean deleteLoanDetail(int loanId) throws CustomException;
	public boolean updateLoanDetail(LoanDetails loandetails) throws CustomException;
	public List<LoanDetails> getAllLoanDetails() throws CustomException;
	public LoanDetails getLoanDetailsById(int loanId) throws CustomException;
}//end of interface

