package com.cg.forestrymanagementcollections.factory;

import com.cg.forestrymanagementcollections.dao.UserDao;
import com.cg.forestrymanagementcollections.dao.UserDaoImpl;
import com.cg.forestrymanagementcollections.service.UserService;
import com.cg.forestrymanagementcollections.service.UserServiceImpl;

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
