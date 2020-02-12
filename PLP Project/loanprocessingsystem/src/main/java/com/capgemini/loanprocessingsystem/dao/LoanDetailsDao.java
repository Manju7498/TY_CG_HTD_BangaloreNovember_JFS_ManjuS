package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.LoanDetails;

public interface LoanDetailsDao {

	public boolean addLoanDetail(LoanDetails loanDetail) throws CustomException;

	public boolean deleteLoanDetail(int loanId) throws CustomException;

	public boolean updateLoanDetail(LoanDetails loanDetail) throws CustomException;

	public List<LoanDetails> getAllLoanDetails() throws CustomException;

	public LoanDetails getLoanDetailsById(int loanId) throws CustomException;

	public boolean searchLoan(int loanId) throws CustomException;
}// end of interface