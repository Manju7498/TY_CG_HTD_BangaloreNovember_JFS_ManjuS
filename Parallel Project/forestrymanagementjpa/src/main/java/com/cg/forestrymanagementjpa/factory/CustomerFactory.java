package com.cg.forestrymanagementjpa.factory;

import com.cg.forestrymanagementjpa.dao.CustomerDao;
import com.cg.forestrymanagementjpa.dao.CustomerDaoImpl;
import com.cg.forestrymanagementjpa.service.CustomerService;
import com.cg.forestrymanagementjpa.service.CustomerServiceImpl;

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
