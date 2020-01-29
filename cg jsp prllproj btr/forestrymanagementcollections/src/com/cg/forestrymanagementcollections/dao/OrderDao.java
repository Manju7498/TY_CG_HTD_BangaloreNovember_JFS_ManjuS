package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.OrderBean;

public interface OrderDao {
	public HashMap<Integer, OrderBean> getAllOrders();

	public OrderBean getOrder(int orderNo);

	public boolean addOrder(int orderNo, OrderBean order);

	public boolean deleteOrder(int orderNo);

	public boolean updateOrder(int orderNo, OrderBean order);
}
