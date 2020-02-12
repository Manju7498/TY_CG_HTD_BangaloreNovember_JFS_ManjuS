package com.cg.forestrymanagementcollections.factory;

import com.cg.forestrymanagementcollections.dao.ContractDao;
import com.cg.forestrymanagementcollections.dao.ContractDaoImpl;
import com.cg.forestrymanagementcollections.service.ContractService;
import com.cg.forestrymanagementcollections.service.ContractServiceImpl;

public class ContractFactory {
	private ContractFactory() {

	}

	public static ContractDao instanceofContractDaoImpl() {
		ContractDao dao = new ContractDaoImpl();
		return dao;
	}

	public static ContractService instanceofContractServices() {
		ContractService services = new ContractServiceImpl();
		return services;
	}
}
