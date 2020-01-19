package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.ContractDao;
import com.cg.forestmanagementspringrest.dto.ContractBean;

@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDao dao;

	@Override
	public boolean addContract(ContractBean contract) {
		return dao.addContract(contract);
	}

	@Override
	public ContractBean getContract(int contractNo) {
		// TODO Auto-generated method stub
		return dao.getContract(contractNo);
	}

	@Override
	public List<ContractBean> getAllContracts() {
		// TODO Auto-generated method stub
		return dao.getAllContracts();
	}

	@Override
	public boolean deleteContract(int contractNo) {
		// TODO Auto-generated method stub
		return dao.deleteContract(contractNo);
	}

	@Override
	public boolean updateContract(ContractBean contract) {
		// TODO Auto-generated method stub
		return dao.updateContract(contract);
	}

}
