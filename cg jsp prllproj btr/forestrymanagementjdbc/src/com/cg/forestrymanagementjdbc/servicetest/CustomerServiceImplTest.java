package com.cg.forestrymanagementjdbc.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.CustomerBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;
import com.cg.forestrymanagementjdbc.service.CustomerService;
import com.cg.forestrymanagementjdbc.service.CustomerServiceImpl;

class CustomerServiceImplTest {
	private CustomerBean customerBean=new CustomerBean();
	private CustomerService customerService=new CustomerServiceImpl();


	@Test
	void testGetAllCustomers() {
		List<CustomerBean> customersList = customerService.getAllCustomers();
		assertNotNull(customersList);
	}

	@Test
	void testCustomerLogin() {
		CustomerBean customer = customerService.customerLogin(4);
		assertNotNull(customer);
	}

	@Test
	void testUpdateCustomer() {
		customerBean = new CustomerBean();
		customerBean.setCustomerId(4);
		customerBean.setCustomerName("syamala");
		customerBean.setEmail("syamalab@gmail.com");
		boolean updateCheck = customerService.updateCustomer(4, customerBean);
		assertEquals(updateCheck, true);
	}

	@Test
	void testDeleteCustomer() {
		boolean deleteCheck = customerService.deleteCustomer(2);
		assertEquals(deleteCheck,false);
	}

	@Test
	void testInsertCustomer() {
		try {
		customerBean = new CustomerBean();
		customerBean.setCustomerId(8756);
		customerBean.setCustomerName("priya");
		customerBean.setStreetAddress1("ts");
		customerBean.setStreetAddress2("hs");
		customerBean.setTown("palamaner");
		customerBean.setPincode(517408);
		customerBean.setEmail("jayasri@gmail.com");
		customerBean.setCustomerPhoneNumber(9550316616l);
		boolean insertCheck = customerService.insertCustomer(customerBean);
		assertEquals(insertCheck, false);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				customerService.insertCustomer(customerBean);
			});
		}
	}
	

}
