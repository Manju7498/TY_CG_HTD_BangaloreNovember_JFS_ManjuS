package com.cg.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.ContractBean;

@SpringBootTest
class ContractServiceImplTest {
		@Autowired
		private ContractService contractService;
		ContractBean contractBean;

		@Test
		void testAddContract() {
			contractBean = new ContractBean();
			contractBean.setContractNo("4444");
			contractBean.setCustomerId("1111");
			contractBean.setHaulierId("2221");
			contractBean.setProductId("3332");
			contractBean.setDeliveryDate("2020-04-06");
			contractBean.setQuantity("5000");
			boolean insertCheck = contractService.addContract(contractBean);
			assertEquals(insertCheck, true);
		}

		@Test
		void testGetContract() {
			ContractBean contractBean = contractService.getContract("4442");
			assertNotNull(contractBean);
		}

		@Test
		void testGetAllContracts() {
			List<ContractBean> contractsList = contractService.getAllContracts();
			assertNotNull(contractsList);
		}

		@Test
		void testDeleteContract() {
			boolean deleteCheck = contractService.deleteContract("9876");
			assertEquals(deleteCheck, false);
		}

		@Test
		void testUpdateContract() {
			contractBean = new ContractBean();
			contractBean.setContractNo("4441");
			contractBean.setCustomerId("1112");
			contractBean.setProductId("3331");
			contractBean.setHaulierId("2221");
			contractBean.setDeliveryDate("2020-04-02");
			contractBean.setQuantity("4000");
			boolean updateCheck = contractService.updateContract("4441", contractBean);
			assertEquals(updateCheck, true);
		}

	
}
