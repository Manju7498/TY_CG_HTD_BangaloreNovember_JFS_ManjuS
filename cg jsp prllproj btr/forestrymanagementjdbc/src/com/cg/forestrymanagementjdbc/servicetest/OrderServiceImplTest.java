package com.cg.forestrymanagementjdbc.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.OrderBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;
import com.cg.forestrymanagementjdbc.service.OrderService;
import com.cg.forestrymanagementjdbc.service.OrderServiceImpl;

class OrderServiceImplTest {

	private OrderBean orderBean=new OrderBean();
	private OrderService orderService=new OrderServiceImpl();


	@Test
	void testGetAllOrders() {
		List<OrderBean> contract = orderService.getAllOrders();
		assertNotNull(contract);
	}

	@Test
	void testOrderLogin() {
		OrderBean contract = orderService.orderLogin(1);
		assertNotNull(contract);
	}

	@Test
	void testUpdateOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo(1);
		orderBean.setCustomerId(22);
		orderBean.setProductId(85);
		boolean check = orderService.updateOrder(1,orderBean);
		assertEquals(check, true);
	}

	@Test
	void testDeleteOrder() {
		boolean check = orderService.deleteOrder(12);
		assertEquals(check, false);
	}

	@Test
	void testInsertOrder() {
		try {
			orderBean.setOrderNo(854);
			orderBean.setCustomerId(12);
			orderBean.setHaulierId(23);
			orderBean.setProductId(34);
			orderBean.setDeliveryDate("07/04/2020");
			orderBean.setQuantity(2000);
			boolean insertContract = orderService.insertOrder(orderBean);
			assertEquals(insertContract, true);
			}catch (Exception e) {
				assertThrows(ForestryExceptions.class, ()-> {
					orderService.insertOrder(orderBean);
				});
			}
	}
}
