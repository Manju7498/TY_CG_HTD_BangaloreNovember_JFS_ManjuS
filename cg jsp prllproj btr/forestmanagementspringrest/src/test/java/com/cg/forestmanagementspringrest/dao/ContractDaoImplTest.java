package com.cg.forestmanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.ContractBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;

@SpringJUnitConfig(classes = { SpringRestTestConfig.class, ORMConfig.class })
class ContractDaoImplTest {
	@Autowired
	public ContractDao contractDao;
	ContractBean contractBean;

	@Test
	void testAddContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo("2875");
		contractBean.setCustomerId("5847");
		contractBean.setHaulierId("655");
		contractBean.setProductId("5425");
		contractBean.setDeliveryDate("02/08/2020");
		contractBean.setDeliveryDay("monday");
		contractBean.setQuantity("5000");
		boolean insertCheck = contractDao.addContract(contractBean);
		assertEquals(insertCheck, false);
	}

	@Test
	void testGetContract() {
		ContractBean contractBean = contractDao.getContract("444");
		assertNotNull(contractBean);
	}

	@Test
	void testGetAllContracts() {
		List<ContractBean> contractsList = contractDao.getAllContracts();
		assertNotNull(contractsList);
	}

	@Test
	void testDeleteContract() {
		boolean deleteCheck = contractDao.deleteContract("8554");
		assertEquals(deleteCheck, false);
	}

	@Test
	void testUpdateContract() {
		contractBean = new ContractBean();
		contractBean.setContractNo("444");
		contractBean.setCustomerId("554");
		contractBean.setHaulierId("645");
		contractBean.setProductId("5454");
		contractBean.setDeliveryDay("monday");
		contractBean.setDeliveryDate("02/08/2028");
		contractBean.setQuantity("4000");
		boolean updateCheck = contractDao.updateContract("444", contractBean);
		assertEquals(updateCheck, true);
	}

}
