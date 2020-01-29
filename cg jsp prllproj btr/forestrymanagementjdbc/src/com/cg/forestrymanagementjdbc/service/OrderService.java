package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.OrderBean;

public interface OrderService {
	public List<OrderBean> getAllOrders();

	public OrderBean orderLogin(int orderNo);

	public boolean insertOrder(OrderBean order);

	public boolean deleteOrder(int orderNo);

	public boolean updateOrder(int contractNo, OrderBean bean);
}
