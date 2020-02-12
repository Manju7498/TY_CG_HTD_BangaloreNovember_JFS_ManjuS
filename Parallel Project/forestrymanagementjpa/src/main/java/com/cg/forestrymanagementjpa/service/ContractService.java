package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.ContractBean;

public interface ContractService {
	public List<ContractBean> getAllContracts();

	public ContractBean contractLogin(int contractNo);

	public boolean deleteContract(int contractno);

	public boolean insertContract(ContractBean bean);

	public boolean updateContract(int contractNo, ContractBean bean);
}
