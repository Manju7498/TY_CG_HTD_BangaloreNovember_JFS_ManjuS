package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDetailsDao;
import com.capgemini.loanprocessingsystem.dao.InterviewInfoDao;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.InterviewInfo;

@Service
public class InterviewInfoServiceImpl implements InterviewInfoService {

	@Autowired
	private InterviewInfoDao interviewDao;
	@Autowired
	private CustomerDetailsDao customerdetails;

	@Override
	public boolean addInterviewInfo(InterviewInfo interviewinfo) throws CustomException {

		if(customerdetails.searchCustomer(interviewinfo.getCustomerId())) {
			return interviewDao.addInterviewInfo(interviewinfo);
		}
		return false;
	}
	@Override
	public boolean deleteInterviewInfo(int slNo) throws CustomException {
		return interviewDao.deleteInterviewInfo(slNo);
	}
	@Override
	public List<InterviewInfo> getAllInterviewInfoDetails() throws CustomException {
		return interviewDao.getAllInterviewInfoDetails();
	}

	@Override
	public boolean updateInterviewInfo(InterviewInfo interview) throws CustomException {
		if(customerdetails.searchCustomer(interview.getCustomerId())) {
			return interviewDao.updateInterviewInfo(interview);
		}
		return false;
	}
	@Override
	public InterviewInfo getInterviewInfoDetailsById(int slNo) throws CustomException {
	
		return interviewDao.getInterviewInfoDetailsById(slNo);
	}
}
