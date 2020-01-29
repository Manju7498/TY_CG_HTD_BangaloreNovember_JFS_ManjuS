package com.cg.forestrymanagementjdbc.factory;

import com.cg.forestrymanagementjdbc.dao.CustomerDao;
import com.cg.forestrymanagementjdbc.dao.CustomerDaoImpl;
import com.cg.forestrymanagementjdbc.service.CustomerService;
import com.cg.forestrymanagementjdbc.service.CustomerServiceImpl;

public class CustomerFactory {
	private CustomerFactory() {

	}

	public static CustomerDao instanceofCustomerDaoImpl() {
		CustomerDao dao = new CustomerDaoImpl();
		return dao;
	}

	public static CustomerService instanceofCustomerServices() {
		CustomerService services = new CustomerServiceImpl();
		return services;
	}
}
