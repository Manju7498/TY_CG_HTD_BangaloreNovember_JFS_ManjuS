package com.cg.forestrymanagementjpa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.OrderBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

class OrderServiceImplTest {
	private static OrderBean orderBean=new OrderBean();
	private static OrderService orderService=new OrderServiceImpl();
	
	@Test
	void testGetAllOrders() {
		List<OrderBean> ordersList = orderService.getAllOrders();
		assertNotNull(ordersList);
	}

	@Test
	void testDeleteOrder() {
		boolean deleteCheck = orderService.deleteOrder(8554);
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
		boolean insertCheck = orderService.insertOrder(orderBean);
		assertEquals(insertCheck, true);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				orderService.insertOrder(orderBean);
			});
		}
	}

	@Test
	void testOrderLogin() {
		OrderBean orderBean=orderService.orderLogin(11);
		assertNotNull(orderBean);
	}

	@Test
	void testUpdateOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo(11);
		orderBean.setDeliveryDate("02/08/2028");
		orderBean.setQuantity(4000);
		boolean insertCheck = orderService.updateOrder(11,orderBean);
		assertEquals(insertCheck, true);
	}

	

}
