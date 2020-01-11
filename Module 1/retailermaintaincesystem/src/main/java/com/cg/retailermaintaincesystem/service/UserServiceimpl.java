package com.cg.retailermaintaincesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.retailermaintaincesystem.dao.UserDao;
import com.cg.retailermaintaincesystem.dto.UserBean;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public boolean register(UserBean bean) {
		// TODO Auto-generated method stub
		return dao.register(bean);
	}

	@Override
	public UserBean login(UserBean bean) {
		// TODO Auto-generated method stub
		return dao.login(bean);
	}

	@Override
	public boolean updatePassword(int id,String password) {
		// TODO Auto-generated method stub
		return dao.updatePassword(id,password);
	}

}
