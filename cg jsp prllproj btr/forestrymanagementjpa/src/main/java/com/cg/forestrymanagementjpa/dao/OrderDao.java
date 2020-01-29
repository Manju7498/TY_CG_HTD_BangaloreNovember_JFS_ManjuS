package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.OrderBean;

public interface OrderDao {
	public List<OrderBean> getAllOrders();

	public OrderBean orderLogin(int orderNo);

	public boolean insertOrder(OrderBean order);

	public boolean deleteOrder(int orderNo);

	public boolean updateOrder(int orderNo, OrderBean bean);
}
