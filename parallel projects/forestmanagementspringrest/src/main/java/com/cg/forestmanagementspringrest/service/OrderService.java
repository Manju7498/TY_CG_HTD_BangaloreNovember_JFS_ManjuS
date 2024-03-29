package com.cg.forestmanagementspringrest.service;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean order);

	public OrderBean getOrder(int orderNo);

	public List<OrderBean> getAllOrders();

	public boolean deleteOrder(int orderNo);

	public boolean updateOrder(OrderBean order);
}
