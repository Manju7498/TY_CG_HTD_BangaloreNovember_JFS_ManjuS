package com.cg.forestrymanagementjdbc.factory;

import com.cg.forestrymanagementjdbc.dao.ContractDao;
import com.cg.forestrymanagementjdbc.dao.ContractDaoImpl;
import com.cg.forestrymanagementjdbc.service.ContractService;
import com.cg.forestrymanagementjdbc.service.ContractServiceImpl;

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
