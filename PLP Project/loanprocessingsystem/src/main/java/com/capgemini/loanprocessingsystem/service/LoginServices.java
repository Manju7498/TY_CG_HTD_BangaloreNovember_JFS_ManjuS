package com.capgemini.loanprocessingsystem.service;

import com.capgemini.loanprocessingsystem.dto.Login;
import com.capgemini.loanprocessingsystem.exception.CustomException;

public interface LoginServices {
	public boolean addAccount(Login addaccount);
	public Login login(Login login) throws CustomException;

}

