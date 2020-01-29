package com.capgemini.jdbc.factory;

import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.dao.UserDAOImpl;
import com.capgemini.jdbc.services.UserServices;
import com.capgemini.jdbc.services.UserServicesImpl;

public class UserFactory {
	private UserFactory() {
		
	}
	public static UserDAO instanceofUSerDAOImpl() {
		UserDAO dao= new UserDAOImpl();
		return dao;
	}
	public static  UserServices instanceofUserServices() {
		UserServices services=new UserServicesImpl();
		return services;
	}
}
