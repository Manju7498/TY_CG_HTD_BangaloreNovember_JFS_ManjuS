package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.UserBean;

public interface UserDao {
	public UserBean login(UserBean bean);

	public boolean register(UserBean bean);
	
	public List<UserBean> getAllUsers();

	public boolean deleteUser(String email);

}
