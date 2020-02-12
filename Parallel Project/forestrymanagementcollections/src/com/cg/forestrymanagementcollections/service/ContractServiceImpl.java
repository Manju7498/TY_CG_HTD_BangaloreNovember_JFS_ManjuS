package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.ContractBean;
import com.cg.forestrymanagementcollections.dao.ContractDao;
import com.cg.forestrymanagementcollections.factory.ContractFactory;

public class ContractServiceImpl implements ContractService {
	ContractDao dao = ContractFactory.instanceofContractDaoImpl();

	@Override
	public HashMap<Integer, ContractBean> getAllContracts() {
		return dao.getAllContracts();
	}

	@Override
	public ContractBean getContract(int contractNo) {
		// TODO Auto-generated method stub
		return dao.getContract(contractNo);
	}

	@Override
	public boolean addContract(int contractNo, ContractBean contract) {
		// TODO Auto-generated method stub
		return dao.addContract(contractNo, contract);
	}

	@Override
	public boolean deleteContract(int contractNo) {
		// TODO Auto-generated method stub
		return dao.deleteContract(contractNo);
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean contract) {
		// TODO Auto-generated method stub
		return dao.updateContract(contractNo, contract);
	}
}
