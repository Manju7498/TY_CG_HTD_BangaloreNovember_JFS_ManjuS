package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.forestrymanagementjpa.bean.CustomerBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

public class CustomerDaoImpl implements CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("forestrymanagement");

	
	public List<CustomerBean> getAllCustomers() {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String deleteCustomerJpql = "from CustomerBean";
			Query query = entityManager.createQuery(deleteCustomerJpql);
			@SuppressWarnings("unchecked")
			List<CustomerBean> list = query.getResultList();
			if (!list.isEmpty()) {
				return list;
			} 
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return null;
	}

	
	public boolean deleteCustomer(int customerId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			//String deleteCustomerJpql = "delete from CustomerBean where customerId=:customerId";
			CustomerBean customerBean1 = entityManager.find(CustomerBean.class, customerId);
			//Query query = entityManager.createQuery(deleteCustomerJpql);
//			query.setParameter("customerId", customerId);
//			int isDeleted = query.executeUpdate();
//			if (isDeleted > 0) {
//				transaction.commit();
//				return true;
//			}
			entityManager.remove(customerBean1);
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return false;
	}

	
	public boolean insertCustomer(CustomerBean bean) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			CustomerBean customerBean1 = entityManager.find(CustomerBean.class, bean.getCustomerId());
			if (customerBean1 == null) {
				transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(bean);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return false;
	}

	
	public CustomerBean customerLogin(int customerId) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			CustomerBean customerBean=entityManager.find(CustomerBean.class, customerId);
			//String getCustomerJpql = "from CustomerBean where customerId=:customerId";
			//Query query = entityManager.createQuery(getCustomerJpql);
			//query.setParameter("customerId", customerId);
			//CustomerBean customerBean = (CustomerBean) query.getSingleResult();
			if (customerBean != null) {
				return customerBean;
			} 
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	
	public boolean updateCustomer(int customerId, CustomerBean bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			CustomerBean customerBean = entityManager.find(CustomerBean.class, customerId);
			transaction.begin();
			String updateCustomerJpql = "update CustomerBean SET customerName=:customerName,email=:email where customerId=:customerId";
			Query query = entityManager.createQuery(updateCustomerJpql);
			query.setParameter("customerName", bean.getCustomerName());
			query.setParameter("email", bean.getEmail());
			query.setParameter("customerId", customerId);
			int isUpdatedName = query.executeUpdate();
			if (isUpdatedName > 0) {
				customerBean.setCustomerName(bean.getCustomerName());
				customerBean.setEmail(bean.getEmail());
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}
}
