package com.cg.forestrymanagementcollections.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementcollections.bean.UserBean;
import com.cg.forestrymanagementcollections.dao.UserDao;
import com.cg.forestrymanagementcollections.dao.UserDaoImpl;

class UserDaoImplTest {
	private UserBean userBean=new UserBean();
	private UserDao userDao=new UserDaoImpl();
	@BeforeEach
	void addUser() {
			userBean.setEmail("manju@gmail.com");
			userBean.setPassword("Manju@518");
			userBean.setRole("client");
			userDao.addUser("manju@gmail.com",userBean );
		}

	@Test
	void testAddUser() {
		userBean.setEmail("syamala@gmail.com");
		userBean.setPassword("Syamala@123");
		userBean.setRole("sceduler");
		boolean check=userDao.addUser("syamala@gmail.com",userBean );
		assertEquals(check, true);
	}

	@Test
	void testLogin() {
		boolean check=userDao.login(userBean);
		assertEquals(check,true);	
	}

	@Test
	void testDeleteUser() {
		boolean result = userDao.deleteUser("manju@gmail.com");
		assertEquals(result, true);
	}

}
