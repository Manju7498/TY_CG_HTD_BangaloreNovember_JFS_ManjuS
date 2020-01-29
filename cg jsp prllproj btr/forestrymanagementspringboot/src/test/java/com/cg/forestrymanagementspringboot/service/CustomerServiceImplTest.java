package com.cg.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.CustomerBean;

@SpringBootTest
class CustomerServiceImplTest {
		@Autowired
		private CustomerService customerService;
		CustomerBean customerBean;

		@Test
		void testAddCustomer() {
			customerBean = new CustomerBean();
			customerBean.setCustomerId("1114");
			customerBean.setCustomerName("priya");
			customerBean.setStreetAddress1("ts");
			customerBean.setStreetAddress2("hs");
			customerBean.setTown("plmr");
			customerBean.setPincode("517408");
			customerBean.setEmail("priya@gmail.com");
			customerBean.setCustomerPhoneNumber("9550316616");
			boolean insertCheck = customerService.addCustomer(customerBean);
			assertEquals(insertCheck, true);
		}

		@Test
		void testGetCustomer() {
			CustomerBean customer = customerService.getCustomer("1112");
			assertNotNull(customer);
		}

		@Test
		void testGetAllCustomers() {
			List<CustomerBean> customersList = customerService.getAllCustomers();
			assertNotNull(customersList);
		}

		@Test
		void testDeleteCustomer() {
			boolean deleteCheck = customerService.deleteCustomer("1");
			assertEquals(deleteCheck,false);
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
			customerBean.setEmail("syamalab@gmail.com");
			customerBean.setCustomerPhoneNumber("9550316616");
			boolean updateCheck = customerService.updateCustomer("1111", customerBean);
			assertEquals(updateCheck, true);
		}

	
}
