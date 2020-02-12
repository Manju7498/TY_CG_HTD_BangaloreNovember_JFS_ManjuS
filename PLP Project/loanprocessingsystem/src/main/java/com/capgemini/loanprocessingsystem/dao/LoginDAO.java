package com.capgemini.loanprocessingsystem.dao;

import com.capgemini.loanprocessingsystem.dto.Login;
import com.capgemini.loanprocessingsystem.exception.CustomException;

public interface LoginDAO {
	public boolean addAccount(Login addaccount);

	public Login login(Login login) throws CustomException;

}