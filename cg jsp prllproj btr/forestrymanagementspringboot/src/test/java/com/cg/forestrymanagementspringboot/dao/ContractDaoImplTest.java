package com.cg.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.ContractBean;

@SpringBootTest
class ContractDaoImplTest {

	@Autowired
	private ContractDao contractDao;
	ContractBean contractBean;

	@Test
	void testAddContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo("4443");
		contractBean.setCustomerId("1112");
		contractBean.setHaulierId("2222");
		contractBean.setProductId("3331");
		contractBean.setDeliveryDate("2020-05-07");
		contractBean.setQuantity("5000");
		boolean insertCheck = contractDao.addContract(contractBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetContract() {
		ContractBean contractBean = contractDao.getContract("4441");
		assertNotNull(contractBean);
	}

	@Test
	void testGetAllContracts() {
		List<ContractBean> contractsList = contractDao.getAllContracts();
		assertNotNull(contractsList);
	}

	@Test
	void testDeleteContract() {
		boolean deleteCheck = contractDao.deleteContract("9833");
		assertEquals(deleteCheck, false);
	}

	@Test
	void testUpdateContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo("4441");
		contractBean.setCustomerId("1112");
		contractBean.setProductId("3332");
		contractBean.setHaulierId("2222");
		contractBean.setDeliveryDate("2028-05-01");
		contractBean.setQuantity("4000");
		boolean updateCheck = contractDao.updateContract("4441", contractBean);
		assertEquals(updateCheck, true);
	}

}
