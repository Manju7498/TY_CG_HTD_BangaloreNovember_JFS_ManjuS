package com.cg.forestrymanagementjpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.UserBean;

class UserDaoImplTest {
	private UserBean userBean;
	private UserDao userDao= new UserDaoImpl();
	@Test
	void testAddUser() {
		userBean=new UserBean();
		userBean.setEmail("chinni@gmail.com");
		userBean.setPassword("gayathri@216");
		userBean.setLoginType("admin");
		boolean check=userDao.addUser(userBean);
		assertEquals(check,true);
	}

	@Test
	void testLogin() {
		
		UserBean userBean1=userDao.login("manju@gmail.com","Manju@518");
		assertNotNull(userBean1);
		
	}

	@Test
	void testDeleteUser() {
		boolean check1=userDao.deleteUser("chinni@gmail.com");
		assertEquals(check1,true);
	}

}
