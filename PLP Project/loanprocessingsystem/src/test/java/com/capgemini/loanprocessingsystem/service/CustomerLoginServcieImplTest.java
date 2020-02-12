package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@SpringBootTest
class CustomerLoginServcieImplTest {
@Autowired
private CustomerLoginService customerLoginService;
	@Test
	void testAddCustomerLoginData() {
		CustomerLoginDetails customerDetails=new CustomerLoginDetails();
		customerDetails.setUsername("Pallavi");
		customerDetails.setPassword("qwerty");
		customerDetails.setStatusReport("Approved");
		try {
			assertTrue(customerLoginService.addCustomerLoginData(customerDetails));
		} 
		catch (CustomException validationsExceptions) {
			assertThrows(CustomException.class, () ->
			{
				customerLoginService.addCustomerLoginData(customerDetails);
			});
		}

		
	}

//	@Test
//	void testDeleteCustomerLoginData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateCustomerLoginData() {
//		fail("Not yet implemented");
//	}

}
