package com.cg.retailermaintaincesystem.dao;

import com.cg.retailermaintaincesystem.dto.UserBean;

public interface UserDao {
	public UserBean login(UserBean bean);

	public boolean register(UserBean bean);

	public boolean updatePassword(int id,String password);
}
