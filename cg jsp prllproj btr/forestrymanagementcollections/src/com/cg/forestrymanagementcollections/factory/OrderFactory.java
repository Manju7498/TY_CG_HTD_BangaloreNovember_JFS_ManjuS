package com.cg.forestrymanagementcollections.factory;

import com.cg.forestrymanagementcollections.dao.OrderDao;
import com.cg.forestrymanagementcollections.dao.OrderDaoImpl;
import com.cg.forestrymanagementcollections.service.OrderService;
import com.cg.forestrymanagementcollections.service.OrderServiceImpl;

public class OrderFactory {
	private OrderFactory() {

	}

	public static OrderDao instanceofOrderDaoImpl() {
		OrderDao dao = new OrderDaoImpl();
		return dao;
	}

	public static OrderService instanceofOrderServices() {
		OrderService services = new OrderServiceImpl();
		return services;
	}
}
