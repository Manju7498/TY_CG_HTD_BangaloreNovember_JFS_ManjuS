package com.cg.forestrymanagementjpa.service;

import com.cg.forestrymanagementjpa.bean.UserBean;
import com.cg.forestrymanagementjpa.dao.UserDao;
import com.cg.forestrymanagementjpa.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();

	public boolean addUser(UserBean user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	public UserBean login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return dao.deleteUser(email);
	}

	
}
