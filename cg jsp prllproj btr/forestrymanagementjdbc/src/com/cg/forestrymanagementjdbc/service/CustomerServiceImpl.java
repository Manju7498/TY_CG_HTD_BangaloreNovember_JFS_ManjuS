package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.CustomerBean;
import com.cg.forestrymanagementjdbc.dao.CustomerDao;
import com.cg.forestrymanagementjdbc.factory.CustomerFactory;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao dao = CustomerFactory.instanceofCustomerDaoImpl();

	@Override
	public List<CustomerBean> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public CustomerBean customerLogin(int customerId) {
		return dao.customerLogin(customerId);
	}

	@Override
	public boolean insertCustomer(CustomerBean customer) {
		return dao.insertCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return dao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean bean) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(customerId, bean);
	}
}
