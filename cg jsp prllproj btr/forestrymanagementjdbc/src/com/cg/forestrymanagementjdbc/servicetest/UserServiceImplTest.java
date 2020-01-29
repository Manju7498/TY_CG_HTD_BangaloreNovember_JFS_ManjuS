package com.cg.forestrymanagementjdbc.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.UserBean;
import com.cg.forestrymanagementjdbc.service.UserService;
import com.cg.forestrymanagementjdbc.service.UserServiceImpl;

class UserServiceImplTest {
	private UserBean userBean=new UserBean();
	private UserService userService=new UserServiceImpl();

	

	@Test
	void testDeleteUser() {
		boolean check1=userService.deleteUser("lakshmi@gmail.com");
		assertEquals(check1,false);
	}

	@Test
	void testLogin() {
		UserBean userBean1=userService.login("manju@gmail.com","Manju@518");
		assertNotNull(userBean1);
	}
	@Test
	void testAddUser() {
		userBean.setEmail("chinni@gmail.com");
		userBean.setPassword("gayathri@216");
		userBean.setRole("client");
		boolean check = userService.addUser(userBean);
		assertEquals(check, true);
	}


}
