package com.cg.forestrymanagementjpa.factory;

import com.cg.forestrymanagementjpa.dao.OrderDao;
import com.cg.forestrymanagementjpa.dao.OrderDaoImpl;
import com.cg.forestrymanagementjpa.service.OrderService;
import com.cg.forestrymanagementjpa.service.OrderServiceImpl;

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
