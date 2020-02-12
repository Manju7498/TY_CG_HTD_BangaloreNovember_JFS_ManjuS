package com.cg.forestrymanagementcollections.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementcollections.bean.ContractBean;
import com.cg.forestrymanagementcollections.dao.ContractDao;
import com.cg.forestrymanagementcollections.dao.ContractDaoImpl;
import com.cg.forestrymanagementcollections.exceptions.ForestryExceptions;

class ContractDaoImplTest {
	private ContractBean contractBean = new ContractBean();
	private ContractDao contractDao = new ContractDaoImpl();

	@BeforeEach
	void addContract() {
		contractBean.setContractNo(167);
		contractBean.setCustomerId(1);
		contractBean.setHaulierId(1);
		contractBean.setProductId(1);
		contractBean.setDeliveryDate("2020/01/31");
		contractBean.setDeliveryDay("sunday");
		contractBean.setQuantity(23);
		contractDao.addContract(167, contractBean);
	}

	@Test
	void testAddContract() {
		contractBean.setContractNo(14);
		contractBean.setCustomerId(14);
		contractBean.setHaulierId(19);
		contractBean.setProductId(19);
		contractBean.setDeliveryDate("2020/02/11");
		contractBean.setDeliveryDay("friday");
		contractBean.setQuantity(23);
		boolean result = contractDao.addContract(14, contractBean);
		assertEquals(result, true);
	}

	@Test
	void testDeleteContract() {
		boolean result = contractDao.deleteContract(167);
		assertEquals(result, true);
	}

	@Test
	void testGetContract() {
		ContractBean result = contractDao.getContract(167);
		assertNotNull(result);
	}

	@Test
	void testGetAllContracts() {
		HashMap<Integer, ContractBean> result = contractDao.getAllContracts();
		assertNotNull(result);
	}

	@Test
	void testUpdateContract() {
		ContractBean contract = new ContractBean();
		contract.setContractNo(167);
		contract.setCustomerId(12);
		contract.setQuantity(345);
		contractDao.updateContract(contract.getContractNo(), contract);
	}

}
