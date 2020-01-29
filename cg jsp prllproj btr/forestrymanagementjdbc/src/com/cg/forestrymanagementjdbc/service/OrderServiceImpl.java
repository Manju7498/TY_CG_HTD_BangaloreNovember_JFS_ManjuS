package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.OrderBean;
import com.cg.forestrymanagementjdbc.dao.OrderDao;
import com.cg.forestrymanagementjdbc.factory.OrderFactory;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = OrderFactory.instanceofOrderDaoImpl();

	@Override
	public List<OrderBean> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	@Override
	public OrderBean orderLogin(int orderNo) {
		// TODO Auto-generated method stub
		return dao.orderLogin(orderNo);
	}

	@Override
	public boolean insertOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return dao.insertOrder(order);
	}

	@Override
	public boolean deleteOrder(int orderNo) {
		// TODO Auto-generated method stub
		return dao.deleteOrder(orderNo);
	}

	@Override
	public boolean updateOrder(int contractNo, OrderBean bean) {
		// TODO Auto-generated method stub
		return dao.updateOrder(contractNo, bean);
	}
}
