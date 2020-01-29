package com.cg.forestrymanagementjdbc.service;

import com.cg.forestrymanagementjdbc.bean.UserBean;

public interface UserService {
	public boolean addUser( UserBean user);

	public UserBean login(String email,String password);

	public boolean deleteUser(String email);

}
