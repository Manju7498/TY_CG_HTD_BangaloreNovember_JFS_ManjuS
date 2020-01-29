package com.cg.forestrymanagementcollections.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementcollections.bean.OrderBean;
import com.cg.forestrymanagementcollections.dao.OrderDao;
import com.cg.forestrymanagementcollections.dao.OrderDaoImpl;

class OrderDaoImplTest {
	private OrderBean orderBean=new OrderBean();
	private OrderDao orderDao=new OrderDaoImpl();
	@BeforeEach
	void addOrder() {
		orderBean.setOrderNo(167);
		orderBean.setCustomerId(1);
		orderBean.setHaulierId(1);
		orderBean.setProductId(1);
		orderBean.setDeliveryDate("2020/01/31");
		orderBean.setQuantity(23);
		orderDao.addOrder(167, orderBean);
	}
	@Test
	void testDeleteOrder() {
		boolean result = orderDao.deleteOrder(167);
		assertEquals(result, true);
	}

	@Test
	void testGetOrder() {
		OrderBean result = orderDao.getOrder(167);
		assertNotNull(result);
	}

	@Test
	void testAddOrder() {
		orderBean.setOrderNo(14);
		orderBean.setCustomerId(14);
		orderBean.setHaulierId(19);
		orderBean.setProductId(19);
		orderBean.setDeliveryDate("2020/02/11");
		orderBean.setQuantity(23);
		boolean result = orderDao.addOrder(14, orderBean);
		assertEquals(result, true);
	}

	@Test
	void testGetAllOrders() {
		HashMap<Integer, OrderBean> result = orderDao.getAllOrders();
		assertNotNull(result);
	}

	@Test
	void testUpdateOrder() {
		OrderBean order = new OrderBean();
		order.setOrderNo(167);
		order.setCustomerId(12);
		order.setQuantity(345);
		orderDao.updateOrder(order.getOrderNo(), order);
	}

}
