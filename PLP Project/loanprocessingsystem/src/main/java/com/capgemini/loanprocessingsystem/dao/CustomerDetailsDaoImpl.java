package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.CustomerDetails;

@Repository
public class CustomerDetailsDaoImpl implements CustomerDetailsDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addCustomer(CustomerDetails customerDetails) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(customerDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("Unable to Process The Request Please Try Again");
		}
	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() throws CustomException {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String viewall = "from CustomerDetails";
			Query query = entityManager.createQuery(viewall);
			List<CustomerDetails> result = query.getResultList();
			return result;
		} catch (Exception e) {
			throw new CustomException("There is Not Data Found In Customer Details");
		}
	}

	@Override
	public boolean deleteCustomerDetails(int custId) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			CustomerDetails pddto = entityManager.find(CustomerDetails.class, custId);
			entityManager.remove(pddto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("The Data is unable to Delete Please try again");
		}

	}

	@Override
	public boolean updateCustomerDetails(CustomerDetails customerdetails) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		CustomerDetails customerDetails1 = entityManager.find(CustomerDetails.class, customerdetails.getCustomerId());
		try {
			if (customerDetails1 != null) {
				customerDetails1.setCustomerName(customerdetails.getCustomerName());
				customerDetails1.setCustomerContactNo(customerdetails.getCustomerContactNo());
				customerDetails1.setAadharNo(customerdetails.getAadharNo());
				customerDetails1.setOccupation(customerdetails.getOccupation());
				customerDetails1.setAnnualIncome(customerdetails.getAnnualIncome());
				customerDetails1.setAssertId(customerdetails.getAssertId());
				customerDetails1.setCustomerAddress(customerdetails.getCustomerAddress());
				customerDetails1.setNomineeName(customerdetails.getNomineeName());
				customerDetails1.setNomineeContactNo(customerdetails.getNomineeContactNo());
				customerDetails1.setNomineePanId(customerdetails.getNomineePanId());
				customerDetails1.setLoanAmount(customerdetails.getLoanAmount());
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new CustomException("The Customer Id that You Have Entered Is Not Exist");
		}
		return false;
	}

	@Override
	public CustomerDetails getCustomerDetailsById(int customerId) throws CustomException {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			CustomerDetails customerDetailsAre = entityManager.find(CustomerDetails.class, customerId);
			return customerDetailsAre;
		} catch (Exception e) {
			throw new CustomException("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
		}
	}

	@Override
	public boolean searchCustomer(int customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerDetails customer = entityManager.find(CustomerDetails.class, customerId);
		if (customer != null) {
			return true;
		}
		return false;
	}


}
