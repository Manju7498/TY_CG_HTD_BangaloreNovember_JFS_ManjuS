package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDetailsDao;
import com.capgemini.loanprocessingsystem.dao.LoanDetailsDao;
import com.capgemini.loanprocessingsystem.dao.LoanStatusDao;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;
import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.dto.LoanDetails;
import com.capgemini.loanprocessingsystem.dto.LoanStatus;
import com.capgemini.loanprocessingsystem.exception.CustomException;
@Service
public class LoanStatusServiceImpl implements LoanStatusServcie {
	double simpleInterest=8.3;
	String userName="not set";
	String password="not set";
	
	@Autowired
	LoanStatusDao loanstatusdao;
	@Autowired 
	 CustomerDetailsDao customerdao;
	
	@Autowired
	LoanDetailsDao loanDao;
CustomerDetails details= new CustomerDetails();
	
   	
   	
   

	@Override
	public boolean addLoanStatusDetails(LoanStatus loanstatus) throws CustomException {
		LoanStatus finalStatus=new LoanStatus();
		LoanDetails loanDetails = new LoanDetails();
		if(!customerdao.searchCustomer(loanstatus.getCustId())) {
			throw new CustomException("CustomerId does'nt Exists!!!");
		} else {
			finalStatus.setCustId(loanstatus.getCustId());
		}

		if(!loanDao.searchLoan(loanstatus.getLoan_Id())) {
			throw new CustomException("loanId does'nt Exists!!!");
		} else {
			finalStatus.setLoan_Id(loanstatus.getLoan_Id());
		}
		CustomerDetails details=customerdao.getCustomerDetailsById(loanstatus.getCustId());
		LoanDetails loanDetails1=loanDao.getLoanDetailsById(loanstatus.getLoan_Id());
		if(!(details.getAnnualIncome()/12>=20000)) {
			finalStatus.setApprovalStatus("Loan Not Approved");
			//throw new CustomException("Loan Cannot Be Approved as the Annual income from all the resources does not fullfill the bank criteria for "+loanstatus.getTypeOfLoan()+"!!!");
			
		} else{
			finalStatus.setApprovalStatus("Loan Approved");
		}
		//for setting the loan interrest rate
		if(loanDetails1.getLoanId() == loanstatus.getLoan_Id() )
		{
			int loanDuration = loanDetails1.getLoanDuration(); // duration should take only 0-9 
			
		    simpleInterest= (loanDuration* 8.3 * details.getLoanAmount())/100; 
		    finalStatus.setInterestRate(simpleInterest);
		} 
		//finalStatus.setInterestRate(simpleInterest);
		finalStatus.setTypeOfLoan(loanstatus.getTypeOfLoan()); 
		// for setting username and password
		
		
			
		return loanstatusdao.addLoanStatusDetails(finalStatus);
	}

	@Override
	public boolean deleteLoanStatusDetails(int statusId) throws CustomException {
		return loanstatusdao.deleteLoanStatusDetails(statusId);
	}

	@Override
	public List<LoanStatus> getAllLoanstatus() throws CustomException {
		return loanstatusdao.getAllLoanstatus();
	}

	@Override
	public boolean updateLoanStatus(LoanStatus loanstatus) throws CustomException {
		return loanstatusdao.updateLoanStatus(loanstatus);
	}

	@Override
	public LoanStatus getTheStatusById(int statusId) throws CustomException {
		return loanstatusdao.getTheStatusById(statusId);
	}

	@Override
	public LoanStatus getAll() throws CustomException {
		return loanstatusdao.getAll();
	}

	@Override
	public boolean addCustomerLogin(CustomerLoginDetails customerLogin) {
		return loanstatusdao.addCustomerLogin(customerLogin) ;
	}

}
