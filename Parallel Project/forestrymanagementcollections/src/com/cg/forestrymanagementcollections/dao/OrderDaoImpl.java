package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.forestrymanagementcollections.bean.OrderBean;
import com.cg.forestrymanagementcollections.exceptions.ForestryExceptions;

public class OrderDaoImpl implements OrderDao {
	private HashMap<Integer, OrderBean> orderbeans = new HashMap<Integer, OrderBean>();
	Set<Entry<Integer, OrderBean>> s = orderbeans.entrySet();
	OrderBean order1 = new OrderBean();

	@Override
	public boolean deleteOrder(int orderNo) {
		for (Entry<Integer, OrderBean> entry : s) {
			try {
				if (entry.getKey() == orderNo) {
					orderbeans.remove(orderNo);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}

	@Override
	public OrderBean getOrder(int orderNo) {
		try {
			if (orderbeans.containsKey(orderNo) == true) {
				return orderbeans.get(orderNo);
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public boolean addOrder(int orderNo, OrderBean order) {
		for (Entry<Integer, OrderBean> entry : s) {
			try {
				if (entry.getKey() == orderNo) {
					return false;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		orderbeans.put(orderNo, order);
		return true;
	}

	@Override
	public HashMap<Integer, OrderBean> getAllOrders() {
		for (Entry<Integer, OrderBean> entry : s) {
			try {
				if (entry != null) {
					return orderbeans;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return null;
	}

	@Override
	public boolean updateOrder(int orderNo, OrderBean order) {
		for (Entry<Integer, OrderBean> entry : s) {
			try {
				if (entry.getKey() == orderNo) {
					orderbeans.replace(orderNo, order);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}

}
