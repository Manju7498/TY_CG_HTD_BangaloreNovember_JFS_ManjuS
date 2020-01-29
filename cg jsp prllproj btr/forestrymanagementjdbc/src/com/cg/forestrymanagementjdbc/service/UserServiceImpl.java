package com.cg.forestrymanagementjdbc.service;

import com.cg.forestrymanagementjdbc.bean.UserBean;
import com.cg.forestrymanagementjdbc.dao.UserDao;
import com.cg.forestrymanagementjdbc.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();

	@Override
	public boolean addUser(UserBean user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return dao.deleteUser(email);
	}



	@Override
	public UserBean login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}
}
