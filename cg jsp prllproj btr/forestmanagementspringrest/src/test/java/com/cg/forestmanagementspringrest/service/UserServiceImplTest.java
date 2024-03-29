package com.cg.forestmanagementspringrest.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.UserBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;

@SpringJUnitConfig(classes = { SpringRestTestConfig.class, ORMConfig.class })
class UserServiceImplTest {

		@Autowired
		public UserService userService;

		UserBean userBean;

		@Test
		void testRegister() {
			userBean = new UserBean();
			userBean.setName("Pranitha");
			userBean.setEmail("pranitha@gmail.com");
			userBean.setPassword("Pranitha@123");
			userBean.setPhoneNumber("9550316616");
			userBean.setRole("scheduler");
			boolean check = userService.register(userBean);
			assertEquals(check, false);
		}

		@Test
		void testLogin() {
			userBean = new UserBean();
			userBean.setEmail("manju@gmail.com");
			userBean.setPassword("Manju@518");
			UserBean userBean1 = userService.login(userBean);
			assertNotNull(userBean1);
		}

		@Test
		void testGetAllUsers() {
			List<UserBean> userList = userService.getAllUsers();
			assertNotNull(userList);
		}

		@Test
		void testDeleteUser() {
			boolean check1 = userService.deleteUser("chinni@gmail.com");
			assertEquals(check1, false);
		}

}
