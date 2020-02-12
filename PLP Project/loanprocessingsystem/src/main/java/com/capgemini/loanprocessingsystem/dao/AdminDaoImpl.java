package com.capgemini.loanprocessingsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.AuthenticationDetails;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addEmployeeDetails(AuthenticationDetails authentication) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(authentication);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException(" Unabl eto Process the request Try Again");
		}
	}

	// delete employee
	public boolean deleteEmployeeDetails(AuthenticationDetails authentication) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			AuthenticationDetails authDto = entityManager.find(AuthenticationDetails.class,
					authentication.getEmployeeId());
			if (authentication.getPassword().equals(authDto.getPassword())) {
				entityManager.remove(authDto);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new CustomException("Invalid creditianls Failed To Delete try again");
		}
		return false;
	}

	// deleteemployee
//	@Override
//	public boolean modifyEmployeeDetails(AuthenticationDetails authentication) throws CustomException {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		try {
//			transaction.begin();
//			AuthenticationDetails authDto = entityManager.find(AuthenticationDetails.class,authentication.getEmployeeId());
//			if (authentication.getPassword().equals(authDto.getPassword())) {
//				authDto.setPassword(authentication.getPassword());
//				authDto.setEmployeeName(authentication.getEmployeeName());
//				authDto.setEmployeeRole(authentication.getEmployeeRole());
//				authDto.setEmail(authentication.getEmail());
//				authDto.setPassword(authentication.getPassword());
//				entityManager.persist(authDto);
//				transaction.commit();
//				return true;
//			}
//			return false;
//		} catch (Exception e) {
//			throw new CustomException("Failed to update Try Again With Correct Creditianls");
//		}
//	}

}
