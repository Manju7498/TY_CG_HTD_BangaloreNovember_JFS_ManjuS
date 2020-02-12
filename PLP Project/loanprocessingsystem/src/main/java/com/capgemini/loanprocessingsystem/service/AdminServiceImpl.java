package com.capgemini.loanprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.AdminDao;
import com.capgemini.loanprocessingsystem.dto.AuthenticationDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao admindao;

	@Override
	public boolean addEmployeeDetails(AuthenticationDetails authentication) throws CustomException {
		// TODO Auto-generated method stub
		return admindao.addEmployeeDetails(authentication);
	}

//	@Override
//	public boolean modifyEmployeeDetails(AuthenticationDetails authentication) throws CustomException {
//		// TODO Auto-generated method stub
//		return admindao.modifyEmployeeDetails(authentication);
//	}

	@Override
	public boolean deleteEmployeeDetails(AuthenticationDetails authentication) throws CustomException {
		// TODO Auto-generated method stub
		return admindao.deleteEmployeeDetails(authentication);
	}
	
}
