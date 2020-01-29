package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.CustomerBean;

public interface CustomerService {

	public List<CustomerBean> getAllCustomers();

	public CustomerBean customerLogin(int customerId);

	public boolean insertCustomer(CustomerBean customer);

	public boolean deleteCustomer(int customerId);

	public boolean updateCustomer(int customerId, CustomerBean bean);
}
