package com.cg.forestmanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.UserBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;

@SpringJUnitConfig(classes = { SpringRestTestConfig.class, ORMConfig.class })
class UserDaoImplTest {

	@Autowired
	public UserDao userDao;

	UserBean userBean;

	@Test
	void testRegister() {
		userBean = new UserBean();
		userBean.setName("Manju");
		userBean.setEmail("manju@gmail.com");
		userBean.setPassword("Manju@518");
		userBean.setPhoneNumber("9550316616");
		userBean.setRole("client");
		boolean check = userDao.register(userBean);
		assertEquals(check, false);
	}

	@Test
	void testLogin() {
		userBean = new UserBean();
		userBean.setEmail("manju@gmail.com");
		userBean.setPassword("Manju@518");
		UserBean userBean1 = userDao.login(userBean);
		assertNotNull(userBean1);
	}

	@Test
	void testGetAllUsers() {
		List<UserBean> userList = userDao.getAllUsers();
		assertNotNull(userList);
	}

	@Test
	void testDeleteUser() {
		boolean check1 = userDao.deleteUser("chinni@gmail.com");
		assertEquals(check1, false);
	}

}
