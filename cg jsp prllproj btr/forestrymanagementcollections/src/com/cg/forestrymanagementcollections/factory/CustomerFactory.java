package com.cg.forestrymanagementcollections.factory;

import com.cg.forestrymanagementcollections.dao.CustomerDao;
import com.cg.forestrymanagementcollections.dao.CustomerDaoImpl;
import com.cg.forestrymanagementcollections.service.CustomerService;
import com.cg.forestrymanagementcollections.service.CustomerServiceImpl;

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
