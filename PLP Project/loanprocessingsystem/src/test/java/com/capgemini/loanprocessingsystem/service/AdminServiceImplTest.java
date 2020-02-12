package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.AuthenticationDetails;
import com.capgemini.loanprocessingsystem.exception.CustomException;
@SpringBootTest
class AdminServiceImplTest {
	@Autowired
	private AdminService adminService=new AdminServiceImpl();

	@Test
	void testAddEmployeeDetails()   {
		AuthenticationDetails authentication=new AuthenticationDetails();
		authentication.setEmployeeId(103);
		authentication.setEmail("qwerty56@gmail.com");
		authentication.setPassword("qwerty");
		authentication.setEmployeeName("Pallavi");
		authentication.setEmployeeRole("Admin");
		try {
		assertTrue(adminService.addEmployeeDetails(authentication));
		}
		catch(CustomException customerexception) {
			assertThrows(CustomException.class, () ->{
				adminService.addEmployeeDetails(authentication);	
			});
		}
	}

	@Test
	void testDeleteEmployeeDetails()   {
		AuthenticationDetails authentication=new AuthenticationDetails();
		authentication.setEmployeeId(103);
		try {
		assertTrue(adminService.deleteEmployeeDetails(authentication));
		}
		catch(CustomException customException) {
			assertThrows(CustomException.class, ()-> {
				adminService.deleteEmployeeDetails(authentication);	
			});
		}
	}



}
