package com.capgemini.loanprocessingsystem.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.loanprocessingsystem.dto.InterviewInfo;
import com.capgemini.loanprocessingsystem.exception.CustomException;

public class InterviewInfoDaoImplTest {

	@Autowired
	InterviewInfoDao interviewInfoDao;

	// adding & testing the interviewInfo 
	@Test
	void testaddInterviewInfo() {
		InterviewInfo interviewinfo = new InterviewInfo();
		interviewinfo.setSlNo(51);
		interviewinfo.setCreditScore(78);
		interviewinfo.setCustomerId(3);
		
		try {
			assertTrue(interviewInfoDao.addInterviewInfo(interviewinfo));
			interviewInfoDao.deleteInterviewInfo(35);
		} catch (Exception e) {
			assertThrows(CustomException.class,()->{
				interviewInfoDao.addInterviewInfo(interviewinfo);
			});
		}	
	}

//	// testing getAll interviewInfo 
//	@Test
//	 public void testgetAllInterviewInfoDetails() {
//		try {
//			assertNotNull(interviewInfoDao.getAllInterviewInfoDetails());
//		} catch (CustomException e) {
//			assertThrows(CustomException.class,()->{
//				interviewInfoDao.getAllInterviewInfoDetails();
//			});
//		}
//	}
//	@Test
//	 public void testupdateInterviewInfo() {
//		InterviewInfo interviewinfo = new InterviewInfo();
//		interviewinfo.setSlNo(35);
//		interviewinfo.setCreditScore(79);
//		interviewinfo.setCustomerId(3);
//		interviewinfo.setLoanStatus("Pending");
//		try {
//			interviewInfoDao.addInterviewInfo(interviewinfo);
//			assertTrue(interviewInfoDao.updateInterviewInfo(interviewinfo));
//			interviewInfoDao.deleteInterviewInfo(35);
//		} catch (Exception e) {
//			assertThrows(CustomException.class,()->{
//				interviewInfoDao.updateInterviewInfo(interviewinfo);
//			});
//			e.printStackTrace();
//		}	
//	}
//	
//	//test case pass
//	@Test
//	 public void testgetInterviewInfoDetailsById() {
//		InterviewInfo interviewinfo = new InterviewInfo();
//		//interviewinfo.setSlNo(9);
//		try {
//			assertNotNull(interviewInfoDao.getInterviewInfoDetailsById(9));
//		} catch (CustomException e) {
//			assertThrows(CustomException.class,()->{
//				interviewInfoDao.getInterviewInfoDetailsById(9);
//			});
//		}
//	}




	
	
	
	
	
	
	
	
	
	
}//end of class
