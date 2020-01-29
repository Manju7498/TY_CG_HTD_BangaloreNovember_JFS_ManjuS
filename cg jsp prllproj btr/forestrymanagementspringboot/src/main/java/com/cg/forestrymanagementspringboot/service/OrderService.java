package com.cg.forestrymanagementspringboot.service;

import java.util.List;

import com.cg.forestrymanagementspringboot.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean order);

	public OrderBean getOrder(String orderNo);

	public List<OrderBean> getAllOrders();

	public boolean deleteOrder(String orderNo);

	public boolean updateOrder(String orderNo,OrderBean order);
}
