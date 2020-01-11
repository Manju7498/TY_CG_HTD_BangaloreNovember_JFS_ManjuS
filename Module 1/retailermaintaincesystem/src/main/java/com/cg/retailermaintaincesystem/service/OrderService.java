package com.cg.retailermaintaincesystem.service;

import com.cg.retailermaintaincesystem.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean order);

	public OrderBean getOrder(int orderId);

}
