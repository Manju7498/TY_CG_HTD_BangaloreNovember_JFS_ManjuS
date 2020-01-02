package com.cg.empwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cg.empwebapp.bean.EmployeeBean;
@Repository
public class EmployeeDaoImpl  implements EmployeeDao{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public EmployeeBean auth(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeBean where employeeEmail=:email";//and password=:password";
		TypedQuery<EmployeeBean> query = entityManager.createQuery(jpql, EmployeeBean.class);
		query.setParameter("email", email);
		//query.setParameter("password", password);
		try {
			EmployeeBean bean = query.getSingleResult();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(password, bean.getPassword())) {
				return bean;
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean register(EmployeeBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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

	/*
	 * @Override public EmployeeBean getEmployee(String email) { String jpql =
	 * "from EmployeeBean where email:email"; EntityManager entityManager =
	 * entityManagerFactory.createEntityManager(); TypedQuery<EmployeeBean> query =
	 * entityManager.createQuery(jpql, EmployeeBean.class);
	 * query.setParameter("email", email); try { return query.getSingleResult(); }
	 * catch (Exception e) { e.printStackTrace(); return null; } }
	 */

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		String jpql = "from EmployeeBean where employeeName:name or employeeEmail:email";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<EmployeeBean> query = entityManager.createQuery(jpql, EmployeeBean.class);
		query.setParameter("name",key);
		query.setParameter("email", key);
		return query.getResultList();
	}

	@Override
	public boolean changePassword(int employeeId, String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		EmployeeBean bean=entityManager.find(EmployeeBean.class,employeeId);
		bean.setPassword(password);
		transaction.commit();
		return false;
	}



}
