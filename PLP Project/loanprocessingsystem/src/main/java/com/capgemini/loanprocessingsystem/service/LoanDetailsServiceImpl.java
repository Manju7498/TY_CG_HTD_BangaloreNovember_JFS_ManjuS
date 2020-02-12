package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.LoanDetailsDao;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.LoanDetails;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	LoanDetailsDao loandetailsdao;

	@Override
	public boolean addLoanDetail(LoanDetails loanDetail) throws CustomException {
		return loandetailsdao.addLoanDetail(loanDetail);
	}

	@Override
	public boolean deleteLoanDetail(int loanId) throws CustomException {

		return loandetailsdao.deleteLoanDetail(loanId);
	}

	@Override
	public boolean updateLoanDetail( LoanDetails loandetails) throws CustomException {
		return loandetailsdao.updateLoanDetail(loandetails);
	}

	@Override
	public List<LoanDetails> getAllLoanDetails() throws CustomException {
		return loandetailsdao.getAllLoanDetails();
	}

	@Override
	public LoanDetails getLoanDetailsById(int loanId) throws CustomException {
		return loandetailsdao.getLoanDetailsById(loanId);
	}


}
