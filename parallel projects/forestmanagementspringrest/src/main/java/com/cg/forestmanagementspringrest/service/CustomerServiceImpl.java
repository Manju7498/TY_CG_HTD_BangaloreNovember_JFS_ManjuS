package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.CustomerDao;
import com.cg.forestmanagementspringrest.dto.CustomerBean;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public boolean addCustomer(CustomerBean customer) {
		// TODO Auto-generated method stub
		return dao.addCustomer(customer);
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.getCustomer(customerId);
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(CustomerBean customer) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(customer);
	}

}
