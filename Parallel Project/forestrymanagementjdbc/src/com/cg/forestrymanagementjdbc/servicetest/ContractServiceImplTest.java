package com.cg.forestrymanagementjdbc.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.ContractBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;
import com.cg.forestrymanagementjdbc.service.ContractService;
import com.cg.forestrymanagementjdbc.service.ContractServiceImpl;

class ContractServiceImplTest {

	static private ContractBean contractBean = new ContractBean();
	static private ContractService contractService = new ContractServiceImpl();

	@Test
	void testInsertContract() {
		try {
		contractBean.setContractNo(142);
		contractBean.setCustomerId(12);
		contractBean.setHaulierId(23);
		contractBean.setProductId(34);
		contractBean.setDeliveryDate("07/04/2020");
		contractBean.setDeliveryDay("tuesday");
		contractBean.setQuantity(2000);
		boolean insertContract = contractService.addContract(contractBean);
		assertEquals(insertContract, true);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				contractService.addContract(contractBean);
			});
		}
	}

	@Test
	void testGetAllContracts() {
		List<ContractBean> contract = contractService.getAllContracts();
		assertNotNull(contract);
	}

	@Test
	void testDeleteContract() {
		boolean check = contractService.deleteContract(12);
		assertEquals(check, false);
	}

	@Test
	void testContractLogin() {
		ContractBean contract = contractService.getContract(453);
		assertNotNull(contract);
	}

	@Test
	void testUpdateContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo(2);
		contractBean.setCustomerId(22);
		boolean check = contractService.updateContract(2,contractBean);
		assertEquals(check, true);
	}

}
