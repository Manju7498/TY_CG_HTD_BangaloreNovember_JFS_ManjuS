package com.cg.forestmanagementspringrest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.forestmanagementspringrest.dto.AdminBean;
import com.cg.forestmanagementspringrest.exceptions.ForestryException;

@Repository
public class AdminDaoImpl implements AdminDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public AdminBean login(AdminBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from AdminBean where email=:email";
		TypedQuery<AdminBean> query = entityManager.createQuery(jpql, AdminBean.class);
		query.setParameter("email",bean.getEmail());
		try {
			AdminBean bean1 = query.getSingleResult();
			if (bean.getPassword().equals(bean.getPassword())) {
				return bean;
			} else {
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean register(AdminBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
