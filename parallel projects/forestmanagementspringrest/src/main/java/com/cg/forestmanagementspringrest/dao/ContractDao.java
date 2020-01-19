package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.ContractBean;

public interface ContractDao {
	public boolean addContract(ContractBean contract);

	public ContractBean getContract(int contractNo);

	public List<ContractBean> getAllContracts();

	public boolean deleteContract(int contractNo);

	public boolean updateContract(ContractBean contract);
}
