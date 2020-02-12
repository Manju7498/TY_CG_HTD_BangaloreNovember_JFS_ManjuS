package com.cg.forestrymanagementjpa.service;

import com.cg.forestrymanagementjpa.bean.UserBean;

public interface UserService {
	public boolean addUser( UserBean user);

	public UserBean login(String email,String password);

	public boolean deleteUser(String email);

}
