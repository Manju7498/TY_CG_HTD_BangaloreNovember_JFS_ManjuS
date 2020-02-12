package com.cg.forestrymanagementjdbc.factory;

import com.cg.forestrymanagementjdbc.dao.UserDao;
import com.cg.forestrymanagementjdbc.dao.UserDaoImpl;
import com.cg.forestrymanagementjdbc.service.UserService;
import com.cg.forestrymanagementjdbc.service.UserServiceImpl;

public class UserFactory {
	private UserFactory() {

	}

	public static UserDao instanceofUserDaoImpl() {
		UserDao dao = new UserDaoImpl();
		return dao;
	}

	public static UserService instanceofUserServices() {
		UserService services = new UserServiceImpl();
		return services;
	}
}
