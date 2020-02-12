package com.cg.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.OrderBean;

@SpringBootTest
class OrderServiceImplTest {
		@Autowired
		public OrderService orderService;
		OrderBean orderBean;

		@Test
		void testAddOrder() {
			orderBean = new OrderBean();
			orderBean.setOrderNo("5554");
			orderBean.setCustomerId("1112");
			orderBean.setHaulierId("2222");
			orderBean.setProductId("3331");
			orderBean.setDeliveryDate("2020-05-04");
			orderBean.setQuantity("4500");
			boolean insertCheck = orderService.addOrder(orderBean);
			assertEquals(insertCheck,true);
		}

		@Test
		void testGetOrder() {
			OrderBean orderBean = orderService.getOrder("5552");
			assertNotNull(orderBean);
		}

		@Test
		void testGetAllOrders() {
			List<OrderBean> ordersList = orderService.getAllOrders();
			assertNotNull(ordersList);
		}

		@Test
		void testDeleteOrder() {
			boolean deleteCheck = orderService.deleteOrder("8554");
			assertEquals(deleteCheck, false);
		}

		@Test
		void testUpdateOrder() {
			orderBean = new OrderBean();
			orderBean.setOrderNo("5551");
			orderBean.setCustomerId("1112");
			orderBean.setHaulierId("2221");
			orderBean.setProductId("3332");
			orderBean.setDeliveryDate("2028-04-06");
			orderBean.setQuantity("4000");
			boolean insertCheck = orderService.updateOrder("5551", orderBean);
			assertEquals(insertCheck, true);
		}


}
