package com.cg.forestrymanagementspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.forestrymanagementspringboot.dto.OrderBean;

@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceUnit
	EntityManagerFactory factory;

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
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public OrderBean getOrder(String orderNo) {
		try {
		EntityManager manager = factory.createEntityManager();
		OrderBean order = manager.find(OrderBean.class, orderNo);
		return order;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<OrderBean> getAllOrders() {
		try {
		EntityManager manager = factory.createEntityManager();
		String getall = "from OrderBean";
		TypedQuery<OrderBean> query = manager.createQuery(getall, OrderBean.class);
		return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteOrder(String orderNo) {
		try {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		OrderBean order = manager.find(OrderBean.class, orderNo);
		if (order != null) {
			transaction.begin();
			manager.remove(order);
			transaction.commit();
			return true;
		} } catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateOrder(String orderNo,OrderBean order) {
		try {
		EntityManager manager = factory.createEntityManager();
		OrderBean order1 = manager.find(OrderBean.class, order.getOrderNo());
		EntityTransaction transaction = manager.getTransaction();
		if (order1 != null) {
			transaction.begin();
			order1.setCustomerId(order.getCustomerId());
			order1.setProductId(order.getProductId());
			order1.setHaulierId(order.getHaulierId());
			order1.setDeliveryDate(order.getDeliveryDate());
			order1.setQuantity(order.getQuantity());
			transaction.commit();
			return true;
		} } catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
