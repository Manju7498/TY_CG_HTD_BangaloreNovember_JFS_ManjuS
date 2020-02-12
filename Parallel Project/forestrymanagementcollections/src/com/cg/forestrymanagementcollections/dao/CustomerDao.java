package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.CustomerBean;

public interface CustomerDao {
	public HashMap<Integer, CustomerBean> getAllCustomers();

	public CustomerBean getCustomer(int customerId);

	public boolean addCustomer(int customerId, CustomerBean customer);

	public boolean deleteCustomer(int customerId);

	public boolean updateCustomer(int customerId, CustomerBean customer);

}
