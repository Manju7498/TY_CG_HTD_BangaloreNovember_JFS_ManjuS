package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.OrderBean;
import com.cg.forestrymanagementjpa.dao.OrderDao;
import com.cg.forestrymanagementjpa.factory.OrderFactory;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = OrderFactory.instanceofOrderDaoImpl();

	public List<OrderBean> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	public OrderBean orderLogin(int orderNo) {
		// TODO Auto-generated method stub
		return dao.orderLogin(orderNo);
	}

	public boolean insertOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return dao.insertOrder(order);
	}

	public boolean deleteOrder(int orderNo) {
		// TODO Auto-generated method stub
		return dao.deleteOrder(orderNo);
	}

	public boolean updateOrder(int orderNo, OrderBean bean) {
		// TODO Auto-generated method stub
		return dao.updateOrder(orderNo, bean);
	}

	
}
