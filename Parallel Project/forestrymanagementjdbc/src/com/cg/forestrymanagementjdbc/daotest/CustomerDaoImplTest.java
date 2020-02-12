package com.cg.forestrymanagementjdbc.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.CustomerBean;
import com.cg.forestrymanagementjdbc.dao.CustomerDao;
import com.cg.forestrymanagementjdbc.dao.CustomerDaoImpl;

class CustomerDaoImplTest {
	private CustomerBean customerBean=new CustomerBean();
	private CustomerDao customerDao=new CustomerDaoImpl();


	@Test
	void testGetAllCustomers() {
		List<CustomerBean> customersList = customerDao.getAllCustomers();
		assertNotNull(customersList);
	}

	@Test
	void testCustomerLogin() {
		CustomerBean customer = customerDao.customerLogin(2);
		assertNotNull(customer);
	}

	@Test
	void testUpdateCustomer() {
		customerBean = new CustomerBean();
		customerBean.setCustomerId(2);
		customerBean.setCustomerName("syamala");
		customerBean.setEmail("syamalab@gmail.com");
		boolean updateCheck = customerDao.updateCustomer(2, customerBean);
		assertEquals(updateCheck, true);
	}

	@Test
	void testDeleteCustomer() {
		boolean deleteCheck = customerDao.deleteCustomer(1);
		assertEquals(deleteCheck,true);
	}

	@Test
	void testInsertCustomer() {
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
}
