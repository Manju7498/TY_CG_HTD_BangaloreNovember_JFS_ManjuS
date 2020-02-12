package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.InterviewInfo;

public interface InterviewInfoDao {

	public boolean addInterviewInfo(InterviewInfo interviewinfo) throws CustomException;

	public boolean deleteInterviewInfo(int slNo) throws CustomException;

	public List<InterviewInfo> getAllInterviewInfoDetails() throws CustomException;

	public boolean updateInterviewInfo(InterviewInfo interview) throws CustomException;

	public InterviewInfo getInterviewInfoDetailsById(int slNo) throws CustomException;

}// end of class
