package com.cg.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.CustomerBean;

@SpringBootTest
class CustomerDaoImplTest {
	@Autowired
	private CustomerDao customerDao;
	CustomerBean customerBean;

	@Test
	void testAddCustomer() {
		customerBean = new CustomerBean();
		customerBean.setCustomerId("1113");
		customerBean.setCustomerName("priya");
		customerBean.setStreetAddress1("ts");
		customerBean.setStreetAddress2("hs");
		customerBean.setTown("palamaner");
		customerBean.setPincode("517408");
		customerBean.setEmail("priya@gmail.com");
		customerBean.setCustomerPhoneNumber("9550316616");
		boolean insertCheck = customerDao.addCustomer(customerBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetCustomer() {
		CustomerBean customer = customerDao.getCustomer("1111");
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
		assertEquals(deleteCheck, false);
	}

	@Test
	void testUpdateCustomer() {
		customerBean = new CustomerBean();
		customerBean.setCustomerId("1111");
		customerBean.setCustomerName("syamala");
		customerBean.setStreetAddress1("sainagar");
		customerBean.setStreetAddress2("street");
		customerBean.setTown("vellore");
		customerBean.setPincode("547125");
		customerBean.setEmail("syamala@gmail.com");
		customerBean.setCustomerPhoneNumber("9550316616");
		boolean updateCheck = customerDao.updateCustomer("1111", customerBean);
		assertEquals(updateCheck, true);
	}

}
