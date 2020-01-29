package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.ContractBean;

public interface ContractDao {
	public boolean addContract(int contractId, ContractBean contract);

	public boolean deleteContract(int contractId);

	public ContractBean getContract(int contractNo);

	public HashMap<Integer, ContractBean> getAllContracts();

	public boolean updateContract(int contractId, ContractBean contract);
}
