package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.ContractBean;
import com.cg.forestrymanagementjdbc.dao.ContractDao;
import com.cg.forestrymanagementjdbc.factory.ContractFactory;

public class ContractServiceImpl implements ContractService {
	ContractDao dao = ContractFactory.instanceofContractDaoImpl();

	@Override
	public List<ContractBean> getAllContracts() {
		return dao.getAllContracts();
	}

	@Override
	public ContractBean getContract(int contractNo) {
		return dao.getContract(contractNo);
	}

	@Override
	public boolean addContract(ContractBean contract) {
		return dao.addContract(contract);
	}

	@Override
	public boolean deleteContract(int contractNo) {
		return dao.deleteContract(contractNo);
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean bean) {
		return dao.updateContract(contractNo, bean);
	}
}
