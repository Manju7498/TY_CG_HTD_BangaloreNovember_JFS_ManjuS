package com.cg.forestrymanagementjdbc.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.OrderBean;
import com.cg.forestrymanagementjdbc.dao.OrderDao;
import com.cg.forestrymanagementjdbc.dao.OrderDaoImpl;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;

class OrderDaoImplTest {
	private OrderBean orderBean=new OrderBean();
	private OrderDao orderDao=new OrderDaoImpl();


	@Test
	void testGetAllOrders() {
		List<OrderBean> contract = orderDao.getAllOrders();
		assertNotNull(contract);
	}

	@Test
	void testOrderLogin() {
		OrderBean contract = orderDao.orderLogin(1);
		assertNotNull(contract);
	}

	@Test
	void testUpdateOrder() {
		orderBean = new OrderBean();
		orderBean.setOrderNo(2);
		orderBean.setCustomerId(22);
		orderBean.setProductId(85);
		boolean check = orderDao.updateOrder(1,orderBean);
		assertEquals(check, true);
	}

	@Test
	void testDeleteOrder() {
		boolean check = orderDao.deleteOrder(12);
		assertEquals(check, false);
	}

	@Test
	void testInsertOrder() {
		try {
			orderBean.setOrderNo(142);
			orderBean.setCustomerId(12);
			orderBean.setHaulierId(23);
			orderBean.setProductId(34);
			orderBean.setDeliveryDate("07/04/2020");
			orderBean.setQuantity(2000);
			boolean insertContract = orderDao.insertOrder(orderBean);
			assertEquals(insertContract, false);
			}catch (Exception e) {
				assertThrows(ForestryExceptions.class, ()-> {
					orderDao.insertOrder(orderBean);
				});
			}
	}

}
