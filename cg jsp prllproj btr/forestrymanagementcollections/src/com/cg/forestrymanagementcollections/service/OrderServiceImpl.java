package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.OrderBean;
import com.cg.forestrymanagementcollections.dao.OrderDao;
import com.cg.forestrymanagementcollections.factory.OrderFactory;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = OrderFactory.instanceofOrderDaoImpl();

	@Override
	public HashMap<Integer, OrderBean> getAllOrders() {
		return dao.getAllOrders();
	}

	@Override
	public OrderBean getOrder(int orderNo) {
		return dao.getOrder(orderNo);
	}

	@Override
	public boolean addOrder(int orderNo, OrderBean order) {
		return dao.addOrder(orderNo, order);
	}

	@Override
	public boolean deleteOrder(int orderNo) {
		return dao.deleteOrder(orderNo);
	}

	@Override
	public boolean updateOrder(int orderNo, OrderBean order) {
		return dao.updateOrder(orderNo, order);
	}
}
