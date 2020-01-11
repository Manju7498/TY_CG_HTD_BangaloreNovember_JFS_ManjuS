package com.cg.retailermaintaincesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.retailermaintaincesystem.dto.UserBean;
import com.cg.retailermaintaincesystem.exceptions.RetailerException;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public UserBean login(UserBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = entityManager.createQuery(jpql, UserBean.class);
		query.setParameter("email", bean.getEmail());
		try {
			UserBean bean1 = query.getSingleResult();
			if (bean.getPassword().equals(bean.getPassword())) {
				return bean;
			} else {
				throw new RetailerException("Password invalid");
			}
		} catch (Exception e) {
			throw new RetailerException("Email invalid");
		}
	}

	@Override
	public boolean register(UserBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new RetailerException("User credentials invalid");
		}
	}

	@Override
	public boolean updatePassword(int id,String password) {
		EntityManager manager = factory.createEntityManager();
		UserBean user1 = manager.find(UserBean.class,id);
		EntityTransaction transaction = manager.getTransaction();
		if (user1 != null) {
			transaction.begin();
			user1.setPassword(password);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

}
