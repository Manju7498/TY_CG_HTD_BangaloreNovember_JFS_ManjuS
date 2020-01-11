package com.cg.retailermaintaincesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.cg.retailermaintaincesystem.dto.OrderBean;
import com.cg.retailermaintaincesystem.exceptions.RetailerException;

@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public OrderBean getOrder(int orderId) {
		EntityManager manager = factory.createEntityManager();
		try {
			OrderBean order = manager.find(OrderBean.class, orderId);
			return order;
		} catch (Exception e) {
			throw new RetailerException("Order is not found");
		}
	}

	@Override
	public boolean addOrder(OrderBean order) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(order);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
