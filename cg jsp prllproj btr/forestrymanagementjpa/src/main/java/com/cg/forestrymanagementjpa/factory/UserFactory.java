package com.cg.forestrymanagementjpa.factory;

import com.cg.forestrymanagementjpa.dao.UserDao;
import com.cg.forestrymanagementjpa.dao.UserDaoImpl;
import com.cg.forestrymanagementjpa.service.UserService;
import com.cg.forestrymanagementjpa.service.UserServiceImpl;

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
