package com.cg.forestrymanagementjpa.factory;

import com.cg.forestrymanagementjpa.dao.ContractDao;
import com.cg.forestrymanagementjpa.dao.ContractDaoImpl;
import com.cg.forestrymanagementjpa.service.ContractService;
import com.cg.forestrymanagementjpa.service.ContractServiceImpl;

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
