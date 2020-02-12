package com.cg.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.OrderBean;

@SpringBootTest
class OrderDaoImplTest {
	@Autowired
	public OrderDao orderDao;
	OrderBean orderBean;

	@Test
	void testAddOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo("5553");
		orderBean.setCustomerId("1111");
		orderBean.setHaulierId("2222");
		orderBean.setProductId("3331");
		orderBean.setDeliveryDate("2020-05-06");
		orderBean.setQuantity("4500");
		boolean insertCheck = orderDao.addOrder(orderBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetOrder() {
		OrderBean orderBean = orderDao.getOrder("5551");
		assertNotNull(orderBean);
	}

	@Test
	void testGetAllOrders() {
		List<OrderBean> ordersList = orderDao.getAllOrders();
		assertNotNull(ordersList);
	}

	@Test
	void testDeleteOrder() {
		boolean deleteCheck = orderDao.deleteOrder("8554");
		assertEquals(deleteCheck, false);
	}

	@Test
	void testUpdateOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo("5551");
		orderBean.setCustomerId("1112");
		orderBean.setProductId("3331");
		orderBean.setHaulierId("2222");
		orderBean.setDeliveryDate("2028-04-06");
		orderBean.setQuantity("4000");
		boolean insertCheck = orderDao.updateOrder("5551", orderBean);
		assertEquals(insertCheck, true);
	}

}
