package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.exception.CustomException;
import com.capgemini.loanprocessingsystem.dto.InterviewInfo;

@Repository
public class InterviewInfoDaoImpl implements InterviewInfoDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addInterviewInfo(InterviewInfo interviewinfo) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(interviewinfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("The Customer Id that you have entered, already exists");
		}
	}

	@Override
	public boolean deleteInterviewInfo(int slNo) throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();

		try {
			transaction.begin();
			InterviewInfo infodetails = entitymanager.find(InterviewInfo.class, slNo);
			if (infodetails != null) {
				entitymanager.remove(infodetails);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new CustomException("The  InterviewInfo Is Unable to Delete Please try Again");
		}
		return false;
	}

//get all info
	@Override
	public List<InterviewInfo> getAllInterviewInfoDetails() throws CustomException {
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from InterviewInfo";
			Query query = entitymanager.createQuery(jpql);
			List<InterviewInfo> list = query.getResultList();
			if (list != null && list.size() != 0) {
				return list;
			}
		} catch (Exception e) {
			throw new CustomException("The Details Are Not found in The Database");
		}
		return null;
	}

//update details
	@Override
	public boolean updateInterviewInfo(InterviewInfo interview) throws CustomException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			InterviewInfo interviewInfo = entityManager.find(InterviewInfo.class, interview.getSlNo());
			interviewInfo.setCreditScore(interview.getCreditScore());
			interviewInfo.setLoanStatus(interview.getLoanStatus());
			interviewInfo.setCustomerId(interview.getCustomerId());
			entityManager.persist(interviewInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomException("The Interview Details Are Unable to Update");
		}
	}

	@Override
	public InterviewInfo getInterviewInfoDetailsById(int slNo) throws CustomException {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			InterviewInfo getSingleResult = entityManager.find(InterviewInfo.class, slNo);
			return getSingleResult;
		} catch (Exception e) {
			throw new CustomException("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE");
		}
	}


}
