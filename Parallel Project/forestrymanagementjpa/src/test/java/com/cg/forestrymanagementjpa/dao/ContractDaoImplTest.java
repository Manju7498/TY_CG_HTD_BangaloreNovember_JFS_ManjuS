package com.cg.forestrymanagementjpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.ContractBean;

class ContractDaoImplTest {
	private static ContractBean contractBean;
	private static ContractDao contractDao = new ContractDaoImpl();

	@BeforeAll
	static void testInsertContractDuplicate() {
		contractBean = new ContractBean();
		contractBean.setContractNo(11);
		contractBean.setCustomerId(5456);
		contractBean.setHaulierId(1);
		contractBean.setProductId(1);
		contractBean.setDeliveryDate("01/05/2020");
		contractBean.setDeliveryDay("monday");
		contractBean.setQuantity(5000);
		boolean insertCheck = contractDao.insertContract(contractBean);
		assertEquals(insertCheck, false);
	}

	@Test
	 void testInsertContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo(2);
		contractBean.setCustomerId(2);
		contractBean.setHaulierId(1);
		contractBean.setProductId(1);
		contractBean.setDeliveryDate("02/08/2020");
		contractBean.setDeliveryDay("monday");
		contractBean.setQuantity(5000);
		boolean insertCheck = contractDao.insertContract(contractBean);
		assertEquals(insertCheck, false);
	}

	@Test
	void testGetAllContracts() {
		List<ContractBean> contractsList = contractDao.getAllContracts();
		assertNotNull(contractsList);
	}

	@Test
	void testDeleteContract() {
		boolean deleteCheck = contractDao.deleteContract(8554);
		assertEquals(deleteCheck, false);
	}


	@Test
	void testContractLogin() {
		ContractBean contractBean=contractDao.contractLogin(1);
		assertNotNull(contractBean);
	}

	@Test
	void testUpdateContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo(1);
		contractBean.setDeliveryDate("02/08/2028");
		contractBean.setQuantity(4000);
		boolean insertCheck = contractDao.updateContract(1,contractBean);
		assertEquals(insertCheck, true);
	}

}
