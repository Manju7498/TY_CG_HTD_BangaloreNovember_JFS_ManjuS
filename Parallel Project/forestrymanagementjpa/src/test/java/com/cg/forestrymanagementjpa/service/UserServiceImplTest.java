package com.cg.forestrymanagementjpa.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.UserBean;

class UserServiceImplTest {

	private UserBean userBean;
	private UserService userService= new UserServiceImpl();
	@Test
	void testAddUser() {
		userBean=new UserBean();
		userBean.setEmail("chinni@gmail.com");
		userBean.setPassword("gayathri@216");
		userBean.setLoginType("admin");
		boolean check=userService.addUser(userBean);
		assertEquals(check,true);
	}

	@Test
	void testLogin() {
		
		UserBean userBean1=userService.login("manju@gmail.com","Manju@518");
		assertNotNull(userBean1);
		
	}

	@Test
	void testDeleteUser() {
		boolean check1=userService.deleteUser("gayathri@gmail.com");
		assertEquals(check1,true);
	}

}
