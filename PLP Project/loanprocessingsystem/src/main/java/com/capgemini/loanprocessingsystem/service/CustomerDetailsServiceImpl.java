package com.capgemini.loanprocessingsystem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDetailsDao;
import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsDao customerdetailsdao;

	@Override
	public boolean addCustomer(CustomerDetails customerDetails) throws CustomException {

		if(!(customerDetails.getAnnualIncome()/12>=20000)) {
			throw new CustomException("Loan Cannot Be Approved as the Annual income from all the resources does not fullfill the bank criteria for "+customerDetails.getLoanType()+"!!!");
		}
		if((customerDetails.getLoanAmount()>1000000)) {
			throw new CustomException("Loan Amount exceeded, as the the maximum loan amount sanction  for "+customerDetails.getLoanType()+"!!!");
		}
		int ageValue=0;
		try {
			ageValue = ageChecker(customerDetails.getDateOfBirth());
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		
		
			if(ageValue<21){
				throw new CustomException("Loan cannot be approved as the age limit does'nt meet our creteria to approve loan");			
			}
		
		return customerdetailsdao.addCustomer(customerDetails);
	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() throws CustomException {

		return customerdetailsdao.getAllCustomerDetails();
	}

	@Override
	public boolean deleteCustomerDetails(int custId) throws CustomException {
		return customerdetailsdao.deleteCustomerDetails(custId);
	}

	@Override
	public boolean updateCustomerDetails(CustomerDetails customerdetails) throws CustomException {

		return customerdetailsdao.updateCustomerDetails(customerdetails);
	}

	@Override
	public CustomerDetails getCustomerDetailsById(int customerId) throws CustomException {
		return customerdetailsdao.getCustomerDetailsById(customerId);
	}

	@Override
	public boolean searchCustomer(int customerId) {

		return customerdetailsdao.searchCustomer(customerId);
	}


	public static int ageChecker(String dobinput) throws ParseException {	  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		//LocalDate date = LocalDate.parse("29-Mar-2019", formatter); 
		LocalDate dob = LocalDate.parse(dobinput,formatter);
		return getAge(dob);		
	} 

	// Returns age given the date of birth
	public static int getAge(LocalDate dob) {
		LocalDate curDate = LocalDate.now();
		return Period.between(dob, curDate).getYears();
	} 

}
