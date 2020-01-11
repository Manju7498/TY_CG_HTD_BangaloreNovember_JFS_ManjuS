package com.cg.retailermaintaincesystem.service;

import com.cg.retailermaintaincesystem.dto.UserBean;

public interface UserService {
	public UserBean login(UserBean bean);

	public boolean register(UserBean bean);

	public boolean updatePassword(int id,String password);

}
