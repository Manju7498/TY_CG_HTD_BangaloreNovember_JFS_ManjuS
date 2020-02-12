package com.cg.forestrymanagementjdbc.dao;

import com.cg.forestrymanagementjdbc.bean.UserBean;

public interface UserDao {
	public boolean addUser(UserBean user);

	public UserBean login(String email,String password);

	public boolean deleteUser(String email);

}
