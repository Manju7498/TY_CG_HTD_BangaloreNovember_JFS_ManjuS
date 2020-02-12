package com.cg.forestrymanagementjdbc.factory;

import com.cg.forestrymanagementjdbc.dao.OrderDao;
import com.cg.forestrymanagementjdbc.dao.OrderDaoImpl;
import com.cg.forestrymanagementjdbc.service.OrderService;
import com.cg.forestrymanagementjdbc.service.OrderServiceImpl;

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
