package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.CustomerBean;
import com.cg.forestrymanagementcollections.dao.CustomerDao;
import com.cg.forestrymanagementcollections.factory.CustomerFactory;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao dao = CustomerFactory.instanceofCustomerDaoImpl();

	@Override
	public HashMap<Integer, CustomerBean> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		return dao.getCustomer(customerId);
	}

	@Override
	public boolean addCustomer(int customerId, CustomerBean customer) {
		return dao.addCustomer(customerId, customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return dao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean customer) {
		return dao.updateCustomer(customerId, customer);
	}
}
