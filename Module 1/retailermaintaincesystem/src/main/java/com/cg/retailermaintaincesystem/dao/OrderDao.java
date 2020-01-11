package com.cg.retailermaintaincesystem.dao;

import com.cg.retailermaintaincesystem.dto.OrderBean;

public interface OrderDao {
	public boolean addOrder(OrderBean product);

	public OrderBean getOrder(int orderId);
}
