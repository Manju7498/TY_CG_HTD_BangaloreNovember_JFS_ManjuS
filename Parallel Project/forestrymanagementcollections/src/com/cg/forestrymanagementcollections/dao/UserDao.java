package com.cg.forestrymanagementcollections.dao;

import com.cg.forestrymanagementcollections.bean.AdminBean;
import com.cg.forestrymanagementcollections.bean.UserBean;

public interface UserDao {
	public boolean addUser(String email, UserBean user);

	public boolean login(UserBean user);

	public boolean deleteUser(String email);

	public boolean signIn(AdminBean admin);
	
	public boolean addAdmin(String email,AdminBean admin);
}
