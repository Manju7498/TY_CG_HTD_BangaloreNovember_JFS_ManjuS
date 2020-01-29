package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.CustomerBean;
import com.cg.forestrymanagementjpa.dao.CustomerDao;
import com.cg.forestrymanagementjpa.factory.CustomerFactory;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao dao = CustomerFactory.instanceofCustomerDaoImpl();

	public List<CustomerBean> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	public CustomerBean customerLogin(int customerId) {
		// TODO Auto-generated method stub
		return dao.customerLogin(customerId);
	}

	public boolean insertCustomer(CustomerBean customer) {
		// TODO Auto-generated method stub
		return dao.insertCustomer(customer);
	}

	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

	public boolean updateCustomer(int customerId, CustomerBean bean) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(customerId, bean);
	}

	
}
