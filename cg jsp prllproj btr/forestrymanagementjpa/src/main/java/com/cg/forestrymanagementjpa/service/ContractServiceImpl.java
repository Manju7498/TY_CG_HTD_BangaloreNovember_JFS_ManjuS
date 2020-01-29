package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.ContractBean;
import com.cg.forestrymanagementjpa.dao.ContractDao;
import com.cg.forestrymanagementjpa.factory.ContractFactory;

public class ContractServiceImpl implements ContractService {
	ContractDao dao = ContractFactory.instanceofContractDaoImpl();

	public List<ContractBean> getAllContracts() {
		// TODO Auto-generated method stub
		return dao.getAllContracts();
	}

	public ContractBean contractLogin(int contractNo) {
		// TODO Auto-generated method stub
		return dao.contractLogin(contractNo);
	}

	public boolean deleteContract(int contractno) {
		// TODO Auto-generated method stub
		return dao.deleteContract(contractno);
	}

	public boolean insertContract(ContractBean bean) {
		// TODO Auto-generated method stub
		return dao.insertContract(bean);
	}

	public boolean updateContract(int contractNo, ContractBean bean) {
		// TODO Auto-generated method stub
		return dao.updateContract(contractNo, bean);
	}
}
