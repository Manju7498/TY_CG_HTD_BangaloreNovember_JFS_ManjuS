package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.dto.CustomerLoginDetails;
import com.capgemini.loanprocessingsystem.dto.LoanStatus;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@Repository
public class LoanStatusDaoImpl implements LoanStatusDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addLoanStatusDetails(LoanStatus loanstatus) throws CustomException {
		System.out.println(loanstatus.getApprovalId());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(loanstatus);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// throw new CustomException("The Customer Id that you have entered, already
			// exists");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteLoanStatusDetails(int statusId) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LoanStatus toDelete = entityManager.find(LoanStatus.class, statusId);
			entityManager.remove(toDelete);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
		}
	}

	@Override
	public List<LoanStatus> getAllLoanstatus() throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from LoanStatus";
			Query query = entitymanager.createQuery(jpql);
			List<LoanStatus> list = query.getResultList();
			if (list != null && list.size() != 0) {
				return list;
			}
		} catch (Exception e) {
			throw new CustomException("The Loan Details Are Unable to Find");
		}
		return null;
	}

	@Override
	public boolean updateLoanStatus(LoanStatus loanStatus) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LoanStatus loanStatusDetails = entityManager.find(LoanStatus.class, loanStatus.getApprovalId());
			loanStatusDetails.setTypeOfLoan(loanStatus.getTypeOfLoan());
			loanStatusDetails.setInterestRate(loanStatus.getInterestRate());
			entityManager.persist(loanStatusDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("Failed To Upadte The Details Please Try Again");
		}
	}

	@Override
	public LoanStatus getTheStatusById(int statusId) throws CustomException {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			LoanStatus pdd = entityManager.find(LoanStatus.class, statusId);
			return pdd;
		} catch (Exception e) {
			throw new CustomException("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
		}
	}

	@Override
	public LoanStatus getAll() throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from LoanStatus";
			Query query = entitymanager.createQuery(jpql);
			LoanStatus list = (LoanStatus) query.getSingleResult();
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			throw new CustomException("The Loan Details Are Unable to Find");
		}
		return null;

	}

	@Override
	public boolean addCustomerLogin(CustomerLoginDetails customerLogin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(customerLogin);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// throw new CustomException("The Login Creditianls Are nOt Found Please Contact
			// To Admin");
			// e.printStackTrace();
		}
		return false;
	}

}
