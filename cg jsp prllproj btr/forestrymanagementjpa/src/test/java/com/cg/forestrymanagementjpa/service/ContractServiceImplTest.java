package com.cg.forestrymanagementjpa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.ContractBean;

class ContractServiceImplTest {

	private static ContractBean contractBean;
	private static ContractService contractService = new ContractServiceImpl();


	@Test
	 void testInsertContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo(285);
		contractBean.setCustomerId(2);
		contractBean.setHaulierId(1);
		contractBean.setProductId(1);
		contractBean.setDeliveryDate("02/08/2020");
		contractBean.setDeliveryDay("monday");
		contractBean.setQuantity(5000);
		boolean insertCheck = contractService.insertContract(contractBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetAllContracts() {
		List<ContractBean> contractsList = contractService.getAllContracts();
		assertNotNull(contractsList);
	}

	@Test
	void testDeleteContract() {
		boolean deleteCheck = contractService.deleteContract(11);
		assertEquals(deleteCheck, true);
	}


	@Test
	void testContractLogin() {
		ContractBean contractBean=contractService.contractLogin(1);
		assertNotNull(contractBean);
	}

	@Test
	void testUpdateContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo(1);
		contractBean.setDeliveryDate("02/08/2028");
		contractBean.setQuantity(4000);
		boolean insertCheck = contractService.updateContract(1,contractBean);
		assertEquals(insertCheck, true);
	}

}
