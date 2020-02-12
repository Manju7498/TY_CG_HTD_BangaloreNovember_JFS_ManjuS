package com.cg.forestmanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.CustomerBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;
@SpringJUnitConfig(classes= {SpringRestTestConfig.class, ORMConfig.class})
class CustomerDaoImplTest {
	@Autowired
	public CustomerDao customerDao;
	
	@Test
	void testAddCustomer() {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerId("8752");
		customerBean.setCustomerName("priya");
		customerBean.setStreetAddress1("ts");
		customerBean.setStreetAddress2("hs");
		customerBean.setTown("palamaner");
		customerBean.setPincode("517408");
		customerBean.setEmail("jayasri@gmail.com");
		customerBean.setCustomerPhoneNumber("9550316616");
		boolean insertCheck = customerDao.addCustomer(customerBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetCustomer() {
		CustomerBean customer = customerDao.getCustomer("111");
		assertNotNull(customer);
	}

	@Test
	void testGetAllCustomers() {
		List<CustomerBean> customersList = customerDao.getAllCustomers();
		assertNotNull(customersList);
	}

	@Test
	void testDeleteCustomer() {
		boolean deleteCheck = customerDao.deleteCustomer("8756");
		assertEquals(deleteCheck,false);
	}

	@Test
	void testUpdateCustomer() {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerName("syamala");
		customerBean.setStreetAddress1("sainagar");
		customerBean.setStreetAddress2("street");
		customerBean.setTown("vellore");
		customerBean.setPincode("547125");
		customerBean.setEmail("syamalab@gmail.com");
		customerBean.setCustomerPhoneNumber("9550316616");
		boolean updateCheck = customerDao.updateCustomer("111", customerBean);
		assertEquals(updateCheck, true);
	}

}
