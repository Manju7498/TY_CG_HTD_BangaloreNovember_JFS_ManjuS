package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.CustomerBean;

public interface CustomerDao {
	public boolean addCustomer(CustomerBean customer);

	public CustomerBean getCustomer(int customerId);

	public List<CustomerBean> getAllCustomers();

	public boolean deleteCustomer(int customerId);

	public boolean updateCustomer(CustomerBean customer);
}
