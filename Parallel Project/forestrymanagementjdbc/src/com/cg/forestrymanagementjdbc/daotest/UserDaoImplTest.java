package com.cg.forestrymanagementjdbc.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.UserBean;
import com.cg.forestrymanagementjdbc.dao.UserDao;
import com.cg.forestrymanagementjdbc.dao.UserDaoImpl;

class UserDaoImplTest {
	private UserBean userBean = new UserBean();
	private UserDao userDao = new UserDaoImpl();

	@Test
	void testAddUser() {
		userBean.setEmail("priya@gmail.com");
		userBean.setPassword("gayathri@216");
		userBean.setRole("client");
		boolean check = userDao.addUser(userBean);
		assertEquals(check, true);
	}

	@Test
	void testDeleteUser() {
		boolean check1 = userDao.deleteUser("pranitha@gmail.com");
		assertEquals(check1, true);
	}

	@Test
	void testLogin() {
		UserBean userBean1 = userDao.login("manju@gmail.com", "Manju@518");
		assertNotNull(userBean1);
	}

}
