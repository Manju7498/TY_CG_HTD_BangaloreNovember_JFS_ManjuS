package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.OrderBean;

public interface OrderService {
	public List<OrderBean> getAllOrders();

	public OrderBean orderLogin(int orderNo);

	public boolean insertOrder(OrderBean order);

	public boolean deleteOrder(int orderNo);

	public boolean updateOrder(int orderNo, OrderBean bean);
}
