package com.cg.forestrymanagementjpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.OrderBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

class OrderDaoImplTest {
	private static OrderBean orderBean=new OrderBean();
	private static OrderDao orderDao=new OrderDaoImpl();
	@BeforeAll
	static void testInsertOrderDuplicate() {
		orderBean = new OrderBean();
		orderBean.setOrderNo(11);
		orderBean.setCustomerId(5456);
		orderBean.setHaulierId(1);
		orderBean.setProductId(1);
		orderBean.setDeliveryDate("01/05/2020");
		orderBean.setQuantity(5000);
		boolean insertCheck = orderDao.insertOrder(orderBean);
		assertEquals(insertCheck, false);
	}
	@Test
	void testGetAllOrders() {
		List<OrderBean> ordersList = orderDao.getAllOrders();
		assertNotNull(ordersList);
	}

	@Test
	void testDeleteOrder() {
		boolean deleteCheck = orderDao.deleteOrder(8554);
		assertEquals(deleteCheck, false);
	}

	@Test
	void testInsertOrder() {
		try {
		orderBean = new OrderBean();
		orderBean.setOrderNo(456);
		orderBean.setCustomerId(2);
		orderBean.setHaulierId(1);
		orderBean.setProductId(1);
		orderBean.setDeliveryDate("02/08/2020");
		orderBean.setQuantity(5000);
		boolean insertCheck = orderDao.insertOrder(orderBean);
		assertEquals(insertCheck, true);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				orderDao.insertOrder(orderBean);
			});
		}
	}

	@Test
	void testOrderLogin() {
		OrderBean orderBean=orderDao.orderLogin(11);
		assertNotNull(orderBean);
	}

	@Test
	void testUpdateOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo(11);
		orderBean.setDeliveryDate("02/08/2028");
		orderBean.setQuantity(4000);
		boolean insertCheck = orderDao.updateOrder(11,orderBean);
		assertEquals(insertCheck, true);
	}

}
