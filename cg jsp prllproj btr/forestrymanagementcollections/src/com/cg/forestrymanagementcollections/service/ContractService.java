package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.ContractBean;

public interface ContractService {
	public HashMap<Integer, ContractBean> getAllContracts();

	public ContractBean getContract(int contractNo);

	public boolean addContract(int contractNo, ContractBean contract);

	public boolean deleteContract(int contractNo);

	public boolean updateContract(int contractNo, ContractBean contract);
}
