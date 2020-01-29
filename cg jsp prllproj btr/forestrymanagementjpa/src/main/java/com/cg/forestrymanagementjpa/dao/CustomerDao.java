package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.CustomerBean;

public interface CustomerDao {
	public List<CustomerBean> getAllCustomers();

	public CustomerBean customerLogin(int customerId);

	public boolean updateCustomer(int customerId, CustomerBean bean);

	public boolean deleteCustomer(int customerId);

	public boolean insertCustomer(CustomerBean bean);
}
