package com.capgemini.loanprocessingsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.loanprocessingsystem.dto.Login;
import com.capgemini.loanprocessingsystem.exception.CustomException;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	Login bean;


	@Override
	public boolean addAccount(Login addaccount) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(addaccount);
			transaction.commit();
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Login login(Login login) throws CustomException {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String login1 = "from Login where email=:id and password=:pass";
		TypedQuery<Login> query = manager.createQuery(login1, Login.class);
		query.setParameter("id", login.getEmail());
		query.setParameter("pass", login.getPassword());
		try {
			 bean = query.getSingleResult();
			if (bean.getPassword().equalsIgnoreCase(login.getPassword()) &&(bean.getEmail().equalsIgnoreCase(login.getEmail()))  ) {
				
					return bean;
				
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new CustomException("User account not found email not registered");
		}
	
	}

}
