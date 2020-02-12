package com.cg.forestrymanagementjpa.dao;

import com.cg.forestrymanagementjpa.bean.UserBean;

public interface UserDao {
	public boolean addUser(UserBean user);

	public UserBean login(String email,String password);

	public boolean deleteUser(String email);

}
