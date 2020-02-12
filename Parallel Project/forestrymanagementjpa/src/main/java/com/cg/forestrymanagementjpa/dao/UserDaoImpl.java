package com.cg.forestrymanagementjpa.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.forestrymanagementjpa.bean.UserBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

public class UserDaoImpl implements UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("forestrymanagement");

	public boolean addUser(UserBean user) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			UserBean userBean1 = entityManager.find(UserBean.class, user.getEmail());
			if (userBean1 == null) {
				transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(user);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return false;
	}

	public UserBean login(String email, String password) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String getUserJpql = "from UserBean where email=:email and password=:password";
			Query query = entityManager.createQuery(getUserJpql);
			query.setParameter("email", email);
			query.setParameter("password",password );
			UserBean userBean = (UserBean) query.getSingleResult();
			if (userBean != null) {
				return userBean;
			} else {
				throw new ForestryExceptions();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		entityManager.close();
		return null;
	}

	public boolean deleteUser(String email) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			UserBean userBean1 = entityManager.find(UserBean.class, email);
			if(userBean1!=null) {
			entityManager.remove(userBean1);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}
	
}
