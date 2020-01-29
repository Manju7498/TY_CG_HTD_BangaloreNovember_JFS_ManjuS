package com.cg.forestrymanagementjpa.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.forestrymanagementjpa.bean.OrderBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

public class OrderDaoImpl implements OrderDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("forestrymanagement");

	
	public List<OrderBean> getAllOrders() {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String getallOrdersJpql = "from OrderBean";
			Query query = entityManager.createQuery(getallOrdersJpql);
			@SuppressWarnings("unchecked")
			List<OrderBean> list = query.getResultList();
			if (!list.isEmpty()) {
				return list;
			} 
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return null;
	}

	
	public boolean deleteOrder(int orderNo) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String deleteOrderJpql = "delete from OrderBean where orderNo=:orderNo";
			//OrderBean orderBean1 = entityManager.find(OrderBean.class, orderNo);
			Query query = entityManager.createQuery(deleteOrderJpql);
			query.setParameter("orderNo", orderNo);
			int isDeleted = query.executeUpdate();
			if (isDeleted > 0) {
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return false;
	}


	public boolean insertOrder(OrderBean bean) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			OrderBean orderBean1 = entityManager.find(OrderBean.class, bean.getOrderNo());
			if (orderBean1 == null) {
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

	
	public OrderBean orderLogin(int orderNo) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String getOrderJpql = "from OrderBean where orderNo=:orderNo";
			Query query = entityManager.createQuery(getOrderJpql);
			query.setParameter("orderNo", orderNo);
			OrderBean orderBean = (OrderBean) query.getSingleResult();
			if (orderBean != null) {
				return orderBean;
			} else {
				throw new ForestryExceptions();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		entityManager.close();
		return null;
	}

	
	public boolean updateOrder(int orderNo, OrderBean bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			OrderBean orderBean = entityManager.find(OrderBean.class, bean.getOrderNo());
			transaction.begin();
			String updateHaulierJpql = "update OrderBean SET deliverydate=:deliverydate,quantity=:quantity where orderNo=:orderNo ";
			Query query = entityManager.createQuery(updateHaulierJpql);
			query.setParameter("deliverydate", bean.getDeliveryDate());
			query.setParameter("quantity",bean.getQuantity());
			query.setParameter("orderNo", bean.getOrderNo());
			int isUpdatedName = query.executeUpdate();
			if (isUpdatedName > 0) {
				orderBean.setDeliveryDate(bean.getDeliveryDate());
				orderBean.setQuantity(bean.getQuantity());
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}
}
