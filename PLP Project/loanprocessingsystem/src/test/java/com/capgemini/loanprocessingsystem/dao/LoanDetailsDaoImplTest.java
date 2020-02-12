package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.LoanDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@SpringBootTest
class LoanDetailsDaoImplTest {

	@Autowired
	private LoanDetailsDao loanDetailDao=new LoanDetailsDaoImpl();
	
//adding successfully
	@Test
	void testAddLoanDetail(){
		LoanDetails loanDetails=new LoanDetails();
		//loanDetails.setLoanId(101);
		loanDetails.setLoanDuration(11);
		loanDetails.setLoanPOI(23.45);
		loanDetails.setTypeOfLoan("Home Construction Loan");
		try {
		assertTrue(loanDetailDao.addLoanDetail(loanDetails));
         loanDetailDao.deleteLoanDetail(loanDetails.getLoanId());
		} catch(Exception validationsExceptions) {
			assertThrows(CustomException.class, () ->
			{
				loanDetailDao.addLoanDetail(loanDetails);	
			});
		}
		
	}

	
//test case pass
//	@Test
//	void testUpdateLoanDetail()   {
//		LoanDetails loanDetails=new LoanDetails();
//		loanDetails.setLoanId(5);
//		loanDetails.setLoanDuration(2);
//		loanDetails.setLoanPOI(23.45);
//		loanDetails.setTypeOfLoan("Home extension Loan");
//		try {
//		assertTrue(loanDetailDao.updateLoanDetail(loanDetails));
//		assertTrue(loanDetailDao.deleteLoanDetail(loanDetails.getLoanId()));
//		}
//		catch(ValidationsExceptions validationsExceptions) {
//			assertThrows(ValidationsExceptions.class, () ->
//			{
//				loanDetailDao.updateLoanDetail(loanDetails);
//			});
//			
//		}
//	}
//
	
	
	//test case pass
	@Test
	void testGetAllLoanDetails()   {
		List<LoanDetails> loandetails;
		try {
			loandetails = loanDetailDao.getAllLoanDetails();
			assertNotNull(loandetails);
		} catch (Exception validationsExceptions) {
			assertThrows(CustomException.class, () ->
			{
				loanDetailDao.getAllLoanDetails();
			});
			
		}
		
	}
}
