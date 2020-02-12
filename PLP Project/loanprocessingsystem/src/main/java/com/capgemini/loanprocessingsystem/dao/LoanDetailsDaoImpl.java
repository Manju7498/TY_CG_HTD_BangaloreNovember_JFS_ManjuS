package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.LoanDetails;

@Repository
public class LoanDetailsDaoImpl implements LoanDetailsDao{
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addLoanDetail(LoanDetails loanDetail) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(loanDetail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("Unable to Process The Request Please Try Again");
		}
	}

	@Override
	public boolean deleteLoanDetail(int loanId) throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		try {
			LoanDetails loanDetails = entitymanager.find(LoanDetails.class, loanId);
			if (loanDetails != null) {
				entitymanager.remove(loanDetails);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new CustomException("The Loan Details Is Unable to Delete Please try Again");
		}
		return false;
	}

	@Override
	public boolean updateLoanDetail(LoanDetails loanDetail) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LoanDetails loanDetailsDto = entityManager.find(LoanDetails.class, loanDetail.getLoanId());
			loanDetailsDto.setTypeOfLoan(loanDetail.getTypeOfLoan());
			loanDetailsDto.setLoanDuration(loanDetail.getLoanDuration());
			loanDetailsDto.setLoanPOI(loanDetail.getLoanPOI());
			entityManager.persist(loanDetailsDto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("The Loan Details Are Unable to Update");
		}
	}

	@Override
	public List<LoanDetails> getAllLoanDetails() throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from LoanDetails";
			Query query = entitymanager.createQuery(jpql);
			List<LoanDetails> list = query.getResultList();
			if (list != null && list.size() != 0) {
				return list;
			}
		} catch (Exception e) {
			throw new CustomException("The Loan Details Are Unable to Find");
		}
		return null;
	}

	@Override
	public boolean searchLoan(int loanId) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		LoanDetails loanStatus = entityManager.find(LoanDetails.class, loanId);
		if (loanStatus != null) {
			return true;
		}
		return false;
	}

	@Override
	public LoanDetails getLoanDetailsById(int loanId) throws CustomException {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			LoanDetails loanStatus = entityManager.find(LoanDetails.class, loanId);
			return loanStatus;
		} catch (Exception e) {
			throw new CustomException("LOAN ID NOT PRESENT IN THE DATABASE!!");
		}
	}

}
