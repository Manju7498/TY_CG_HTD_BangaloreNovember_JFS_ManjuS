package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.OrderBean;

public interface OrderService {
	public HashMap<Integer, OrderBean> getAllOrders();

	public OrderBean getOrder(int OrderNo);

	public boolean addOrder(int orderNo, OrderBean order);

	public boolean deleteOrder(int orderNo);

	public boolean updateOrder(int orderNo, OrderBean order);
}
