package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.ContractBean;

public interface ContractService {
	public List<ContractBean> getAllContracts();

	public ContractBean getContract(int contractNo);

	public boolean deleteContract(int contractno);

	public boolean addContract(ContractBean bean);

	public boolean updateContract(int contractNo, ContractBean bean);
}
