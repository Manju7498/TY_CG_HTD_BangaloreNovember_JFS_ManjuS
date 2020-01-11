package com.cg.retailermaintaincesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.retailermaintaincesystem.dao.OrderDao;
import com.cg.retailermaintaincesystem.dto.OrderBean;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;

	@Override
	public boolean addOrder(OrderBean order) {
		return dao.addOrder(order);
	}

	@Override
	public OrderBean getOrder(int orderId) {
		// TODO Auto-generated method stub
		return dao.getOrder(orderId);
	}

}
