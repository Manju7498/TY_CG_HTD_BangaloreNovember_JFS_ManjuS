package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.CustomerDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;
@SpringBootTest
class CustomerDetailsDaoImplTest {

	@Autowired
	private CustomerDetailsDao customerDeatilDao=new CustomerDetailsDaoImpl();


	@Test
	void testAddCustomer() {
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setAadharNo("2024341823452");
		//customerDetails.setAnnualIncome(76544676);
		customerDetails.setAssertId(201);
		customerDetails.setCustomerAddress("TamilNadu");
		customerDetails.setCustomerContactNo(99184923428L);
		//customerDetails.setCustomerId(181);
		customerDetails.setCustomerName("Diksha");
		customerDetails.setLoanAmount(300000);
		customerDetails.setNomineeContactNo(1234567890l);
		customerDetails.setNomineeName("vinay");
		customerDetails.setLoanType("Homeextension");
		customerDetails.setDateOfBirth("12Jan2020");
		customerDetails.setNomineePanId("TL23XBW778");
		customerDetails.setOccupation("Student");
		customerDetails.setAnnualIncome(76544676d);
		try {
			assertTrue(customerDeatilDao.addCustomer(customerDetails));
		} 
		catch (Exception validationsExceptions) {
			assertThrows(CustomException.class, () ->
			{
				customerDeatilDao.addCustomer(customerDetails);
			});
		}
		
	}
	@Test
	void testGetAllCustomerDetails() {
		try {
			List<CustomerDetails> customerDetails=customerDeatilDao.getAllCustomerDetails();
			assertNotNull(customerDetails);
		}
			catch (CustomException customException) {
				assertThrows(CustomException.class, () ->
				{
					customerDeatilDao.getAllCustomerDetails();
				});
		}
	}

	@Test
	void testDeleteCustomerDetails() {
		CustomerDetails customerdetails=new CustomerDetails();
		customerdetails.setCustomerId(101);
		try {
			assertTrue(customerDeatilDao.deleteCustomerDetails(customerdetails.getCustomerId()));
		}  catch (CustomException customException) {
			assertThrows(CustomException.class, () ->
			{
				customerDeatilDao.deleteCustomerDetails(customerdetails.getCustomerId());
			});
		}
	}

	@Test
	void testUpdateCustomerDetails() {
		CustomerDetails customerDetails=new CustomerDetails();
		//CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setAadharNo("2024341823452");
		//customerDetails.setAnnualIncome(76544676);
		customerDetails.setAssertId(201);
		customerDetails.setCustomerAddress("TamilNadu");
		customerDetails.setCustomerContactNo(99184923428L);
		customerDetails.setCustomerId(37);
		customerDetails.setCustomerName("Santosh");
		customerDetails.setLoanAmount(300000);
		customerDetails.setNomineeContactNo(1234567890l);
		customerDetails.setNomineeName("vinay");
		customerDetails.setLoanType("Homeextension");
		customerDetails.setDateOfBirth("12Jan2020");
		customerDetails.setNomineePanId("TL23XBW778");
		customerDetails.setOccupation("Student");
		customerDetails.setAnnualIncome(76544676d);
		try {
			assertTrue(customerDeatilDao.updateCustomerDetails(customerDetails));
			customerDeatilDao.deleteCustomerDetails(37);
		} catch (Exception validationsExceptions) {
			assertThrows(CustomException.class, () ->
			{
				customerDeatilDao.updateCustomerDetails(customerDetails);	
			});
		
		}
		
	}

}
