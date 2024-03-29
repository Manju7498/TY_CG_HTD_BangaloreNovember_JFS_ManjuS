package com.cg.forestmanagementspringrest.service;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.ContractBean;

public interface ContractService {
	public boolean addContract(ContractBean contract);

	public ContractBean getContract(String contractNo);

	public List<ContractBean> getAllContracts();

	public boolean deleteContract(String contractNo);

	public boolean updateContract(String contractNo,ContractBean contract);
}
