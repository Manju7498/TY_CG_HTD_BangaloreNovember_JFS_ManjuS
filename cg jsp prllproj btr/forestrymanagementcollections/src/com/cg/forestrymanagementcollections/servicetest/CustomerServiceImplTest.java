package com.cg.forestrymanagementcollections.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementcollections.bean.CustomerBean;
import com.cg.forestrymanagementcollections.service.CustomerService;
import com.cg.forestrymanagementcollections.service.CustomerServiceImpl;

class CustomerServiceImplTest {

	private CustomerBean customerBean = new CustomerBean();
	private CustomerService customerService = new CustomerServiceImpl();

	@BeforeEach
	void addCustomer() {
		customerBean.setCustomerId(8544);
		customerBean.setCustomerName("manju");
		customerBean.setStreetAddress1("#sainagar");
		customerBean.setStreetAddress2("MT Road");
		customerBean.setTown("vellore");
		customerBean.setPincode(542156);
		customerBean.setEmail("manju@gmail.com");
		customerService.addCustomer(8544, customerBean);
	}

	@Test
	void testAddCustomer() {
		customerBean.setCustomerId(3244);
		customerBean.setCustomerName("pranitha");
		customerBean.setStreetAddress1("Hosa Road");
		customerBean.setStreetAddress2("BTM");
		customerBean.setTown("Synagunta");
		customerBean.setPincode(548541);
		customerBean.setEmail("pranitha@gmail.com");
		boolean result=customerService.addCustomer(3244, customerBean);
		assertEquals(result, true);
	}

	@Test
	void testDeleteCustomer() {
		boolean result = customerService.deleteCustomer(8544);
		assertEquals(result, true);
	}

	@Test
	void testGetCustomer() {
		CustomerBean result = customerService.getCustomer(8544);
		assertNotNull(result);
	}

	@Test
	void testGetAllCustomers() {
		HashMap<Integer, CustomerBean> result = customerService.getAllCustomers();
		assertNotNull(result);
	}

	@Test
	void testUpdateCustomer() {
		CustomerBean customer = new CustomerBean();
		customer.setCustomerId(8544);
		customer.setCustomerName("syamala");
		customer.setEmail("syamala@gmail.com");
		customerService.updateCustomer(customer.getCustomerId(), customer);
	}


}
