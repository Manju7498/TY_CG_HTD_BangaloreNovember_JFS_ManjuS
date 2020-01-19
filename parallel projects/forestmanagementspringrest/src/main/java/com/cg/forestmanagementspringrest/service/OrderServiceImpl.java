package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.OrderDao;
import com.cg.forestmanagementspringrest.dto.OrderBean;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;

	@Override
	public boolean addOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return dao.addOrder(order);
	}

	@Override
	public OrderBean getOrder(int orderNo) {
		// TODO Auto-generated method stub
		return dao.getOrder(orderNo);
	}

	@Override
	public List<OrderBean> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	@Override
	public boolean deleteOrder(int orderNo) {
		// TODO Auto-generated method stub
		return dao.deleteOrder(orderNo);
	}

	@Override
	public boolean updateOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return dao.updateOrder(order);
	}
}
