package com.capgemini.loanprocessingsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.dto.InterviewInfo;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@Repository
public class CustomerLoginDaoImpl implements CustomerLoginDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(customerlogin);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// throw new CustomException("The Login Creditianls Are nOt Found Please Contact
			// To Admin");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomerLoginData(String username) throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();

		try {
			transaction.begin();
			CustomerLoginDetails infodetails = entitymanager.find(CustomerLoginDetails.class, username);
			if (infodetails != null) {
				entitymanager.remove(username);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new CustomException("The  Data Is Unable to Delete Please try Again");
		}
		return false;
	}

	@Override
	public boolean updateCustomerLoginData(CustomerLoginDetails customerlogin) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			CustomerLoginDetails getdetails = entityManager.find(CustomerLoginDetails.class,
					customerlogin.getUsername());
			getdetails.setPassword(customerlogin.getPassword());
			getdetails.setStatusReport(customerlogin.getStatusReport());
			entityManager.persist(getdetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("The Customer Details Are Unable to Update");
		}

	}

	@Override
	public CustomerLoginDetails loginSingleUserCustomer(CustomerLoginDetails loginDetails) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			CustomerLoginDetails fetchCreditianls = entityManager.find(CustomerLoginDetails.class,
					loginDetails.getUsername());
			if (fetchCreditianls.getPassword().equals(loginDetails.getPassword())) {
				return fetchCreditianls;
			}
		} catch (Exception e) {
			throw new CustomException(
					"The username and password didn`t matched Please try again with correct Creditianls");
		}
		return null;
	}
}
//end of class
