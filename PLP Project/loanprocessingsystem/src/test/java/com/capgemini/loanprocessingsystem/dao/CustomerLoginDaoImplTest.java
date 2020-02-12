package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;
@SpringBootTest
class CustomerLoginDaoImplTest {

	@Autowired
	private CustomerLoginDao customerLoginDao=new CustomerLoginDaoImpl();
		@Test
		void testAddCustomerLoginData() {
			CustomerLoginDetails customerDetails=new CustomerLoginDetails();
			customerDetails.setUsername("Manas");
			customerDetails.setPassword("qwerty");
			customerDetails.setStatusReport("Approved");
			try {
				assertTrue(customerLoginDao.addCustomerLoginData(customerDetails));
			} 
			catch (Exception validationsExceptions) {
				assertThrows(CustomException.class, () ->
				{
					customerLoginDao.addCustomerLoginData(customerDetails);
				});
			}
		}
		@Test
		void testDeleteCustomerLoginData() {
			CustomerLoginDetails customerLoginDetails=new CustomerLoginDetails();
			customerLoginDetails.setUsername("myname");
			try {
				assertTrue(customerLoginDao.deleteCustomerLoginData(customerLoginDetails.getUsername()));
			}  catch (Exception customException) {
				assertThrows(CustomException.class, () ->
				{
					customerLoginDao.deleteCustomerLoginData(customerLoginDetails.getUsername());
				});
			}	
		}
		
		

}
