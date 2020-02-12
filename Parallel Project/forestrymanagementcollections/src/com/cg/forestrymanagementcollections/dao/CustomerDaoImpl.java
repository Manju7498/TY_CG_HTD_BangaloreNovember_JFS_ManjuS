package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;
import java.util.Set;
import com.cg.forestrymanagementcollections.bean.CustomerBean;
import com.cg.forestrymanagementcollections.exceptions.ForestryExceptions;
import java.util.Map.Entry;

public class CustomerDaoImpl implements CustomerDao {
	private HashMap<Integer, CustomerBean> customerbeans = new HashMap<Integer, CustomerBean>();
	Set<Entry<Integer, CustomerBean>> s = customerbeans.entrySet();
	CustomerBean customer1 = new CustomerBean();

	@Override
	public boolean addCustomer(int customerId, CustomerBean customer) {
		for (Entry<Integer, CustomerBean> entry : s) {
			try {
				if (entry.getKey() == customerId) {
					return false;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		customerbeans.put(customerId, customer);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		for (Entry<Integer, CustomerBean> entry : s) {
			try {
				if (entry.getKey() == customerId) {
					customerbeans.remove(customerId);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		try {
			if (customerbeans.containsKey(customerId) == true) {
				return customerbeans.get(customerId);
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public HashMap<Integer, CustomerBean> getAllCustomers() {
		for (Entry<Integer, CustomerBean> entry : s) {
			try {
				if (entry != null) {
					return customerbeans;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return null;
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean customer) {
		for (Entry<Integer, CustomerBean> entry : s) {
			try {
				if (entry.getKey() == customerId) {
					customerbeans.replace(customerId, customer);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}
}
