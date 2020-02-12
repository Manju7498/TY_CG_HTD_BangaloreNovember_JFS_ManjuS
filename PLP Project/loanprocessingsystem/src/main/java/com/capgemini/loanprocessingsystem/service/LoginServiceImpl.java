package com.capgemini.loanprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.LoginDAO;
import com.capgemini.loanprocessingsystem.dto.Login;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@Service
public class LoginServiceImpl implements LoginServices{
	@Autowired // Instead of making object of EmployeeDao
	private LoginDAO dao;

	@Override
	public boolean addAccount(Login addaccount) {
		return dao.addAccount(addaccount);
	}

	@Override
	public Login login(Login login) throws CustomException {
		return dao.login(login);
	}
	

}
