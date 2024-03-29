package com.cg.forestrymanagementjpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.CustomerBean;

class CustomerDaoImplTest {
	public static CustomerBean customerBean;
	public static CustomerDao customerDao = new CustomerDaoImpl();

	@BeforeAll
	@Test
	static void testInsertCustomerDuplicate() {
		customerBean = new CustomerBean();
		customerBean.setCustomerId(8756);
		customerBean.setCustomerName("priya");
		customerBean.setStreetAddress1("ts");
		customerBean.setStreetAddress2("hs");
		customerBean.setTown("palamaner");
		customerBean.setPincode(517408);
		customerBean.setEmail("jayasri@gmail.com");
		customerBean.setCustomerPhoneNumber(9550316616l);
		boolean insertCheck = customerDao.insertCustomer(customerBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetAllCustomers() {
		List<CustomerBean> customersList = customerDao.getAllCustomers();
		assertNotNull(customersList);
	}

	@Test
	 void testDeleteCustomer() {
		boolean deleteCheck = customerDao.deleteCustomer(8752);
		assertEquals(deleteCheck,true);
	}
	@Test
	 void testInsertCustomer() {
		customerBean = new CustomerBean();
		customerBean.setCustomerId(8752);
		customerBean.setCustomerName("priya");
		customerBean.setStreetAddress1("ts");
		customerBean.setStreetAddress2("hs");
		customerBean.setTown("palamaner");
		customerBean.setPincode(517408);
		customerBean.setEmail("jayasri@gmail.com");
		customerBean.setCustomerPhoneNumber(9550316616l);
		boolean insertCheck = customerDao.insertCustomer(customerBean);
		assertEquals(insertCheck, false);
	}

	@Test
	void testCustomerLogin() {
		CustomerBean customer = customerDao.customerLogin(1);
		assertNotNull(customer);
	}

	@Test
	void testUpdateCustomer() {
		customerBean = new CustomerBean();
		customerBean.setCustomerName("syamala");
		customerBean.setStreetAddress1("sainagar");
		customerBean.setStreetAddress2("street");
		customerBean.setTown("vellore");
		customerBean.setPincode(547125);
		customerBean.setEmail("syamalab@gmail.com");
		customerBean.setCustomerPhoneNumber(9550316616l);
		boolean updateCheck = customerDao.updateCustomer(2, customerBean);
		assertEquals(updateCheck, true);
	}

}
