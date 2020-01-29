package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;
import java.util.Set;
import com.cg.forestrymanagementcollections.bean.ContractBean;
import com.cg.forestrymanagementcollections.exceptions.ForestryExceptions;

import java.util.Map.Entry;

public class ContractDaoImpl implements ContractDao {
	private HashMap<Integer, ContractBean> contractbeans = new HashMap<Integer, ContractBean>();
	Set<Entry<Integer, ContractBean>> set = contractbeans.entrySet();
	ContractBean contract1 = new ContractBean();

	@Override
	public boolean addContract(int contractNo, ContractBean contract) {
		for (Entry<Integer, ContractBean> entry : set) {
			try {
				if (entry.getKey() == contractNo) {
					return false;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		contractbeans.put(contractNo, contract);
		return true;
	}

	@Override
	public boolean deleteContract(int contractNo) {
		for (Entry<Integer, ContractBean> entry : set) {
			try {
				if (entry.getKey() == contractNo) {
					contractbeans.remove(contractNo);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}

	@Override
	public ContractBean getContract(int contractNo) {
		try {
			if (contractbeans.containsKey(contractNo) == true) {
				return contractbeans.get(contractNo);
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public HashMap<Integer, ContractBean> getAllContracts() {
		for (Entry<Integer, ContractBean> entry : set) {
			try {
				if (entry != null) {
					return contractbeans;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return null;
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean contract) {
		for (Entry<Integer, ContractBean> entry : set) {
			try {
				if (entry.getKey() == contractNo) {
					contractbeans.replace(contractNo, contract);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}
}
