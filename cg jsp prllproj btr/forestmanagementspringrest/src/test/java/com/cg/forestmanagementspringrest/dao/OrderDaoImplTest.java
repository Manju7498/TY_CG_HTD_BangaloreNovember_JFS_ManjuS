package com.cg.forestmanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.OrderBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;

@SpringJUnitConfig(classes = { SpringRestTestConfig.class, ORMConfig.class })
class OrderDaoImplTest {
	@Autowired
	public OrderDao orderDao;

	OrderBean orderBean;

	@Test
	void testAddOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo("544");
		orderBean.setCustomerId("456");
		orderBean.setHaulierId("563");
		orderBean.setProductId("546");
		orderBean.setDeliveryDate("02/08/2020");
		orderBean.setQuantity("4500");
		boolean insertCheck = orderDao.addOrder(orderBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetOrder() {
		OrderBean orderBean = orderDao.getOrder("456");
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
		orderBean.setOrderNo("456");
		orderBean.setDeliveryDate("02/08/2028");
		orderBean.setQuantity("4000");
		boolean insertCheck = orderDao.updateOrder("456", orderBean);
		assertEquals(insertCheck, true);
	}

}
