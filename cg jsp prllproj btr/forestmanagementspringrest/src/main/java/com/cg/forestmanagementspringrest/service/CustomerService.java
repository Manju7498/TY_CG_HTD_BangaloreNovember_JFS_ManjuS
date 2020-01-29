package com.cg.forestmanagementspringrest.service;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.CustomerBean;

public interface CustomerService {
	public boolean addCustomer(CustomerBean customer);

	public CustomerBean getCustomer(String customerId);

	public List<CustomerBean> getAllCustomers();

	public boolean deleteCustomer(String customerId);

	public boolean updateCustomer(String customerId,CustomerBean customer);
}
