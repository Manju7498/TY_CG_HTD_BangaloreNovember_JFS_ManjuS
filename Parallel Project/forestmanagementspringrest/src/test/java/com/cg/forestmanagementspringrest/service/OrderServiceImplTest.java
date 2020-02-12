package com.cg.forestmanagementspringrest.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.OrderBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;

@SpringJUnitConfig(classes = { SpringRestTestConfig.class, ORMConfig.class })
class OrderServiceImplTest {

		@Autowired
		public OrderService orderService;

		OrderBean orderBean;

		@Test
		void testAddOrder() {
			orderBean = new OrderBean();
			orderBean.setOrderNo("8546");
			orderBean.setCustomerId("111");
			orderBean.setHaulierId("222");
			orderBean.setProductId("333");
			orderBean.setDeliveryDate("02/08/2020");
			orderBean.setQuantity("4500");
			boolean insertCheck = orderService.addOrder(orderBean);
			assertEquals(insertCheck, false);
		}

		@Test
		void testGetOrder() {
			OrderBean orderBean = orderService.getOrder("544");
			assertNotNull(orderBean);
		}

		@Test
		void testGetAllOrders() {
			List<OrderBean> ordersList = orderService.getAllOrders();
			assertNotNull(ordersList);
		}

		@Test
		void testDeleteOrder() {
			boolean deleteCheck = orderService.deleteOrder("456");
			assertEquals(deleteCheck, false);
		}

		@Test
		void testUpdateOrder() {
			orderBean = new OrderBean();
			orderBean.setOrderNo("544");
			orderBean.setCustomerId("111");
			orderBean.setProductId("333");
			orderBean.setHaulierId("222");
			orderBean.setDeliveryDate("02/08/2028");
			orderBean.setQuantity("4000");
			boolean insertCheck = orderService.updateOrder("544", orderBean);
			assertEquals(insertCheck, true);
		}

}
