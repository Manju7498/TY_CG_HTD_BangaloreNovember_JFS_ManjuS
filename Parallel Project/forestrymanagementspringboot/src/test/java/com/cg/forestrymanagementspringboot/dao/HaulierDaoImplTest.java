package com.cg.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.HaulierBean;
import com.cg.forestrymanagementspringboot.exceptions.ForestryExceptions;

@SpringBootTest
class HaulierDaoImplTest {
	@Autowired
	public HaulierDao haulierDao;
	HaulierBean haulierBean;
	@Test
	void testAddHaulier() {
		try {
			haulierBean = new HaulierBean();
			haulierBean.setHaulierId("2223");
			haulierBean.setHaulierName("priya");
			haulierBean.setStreetAddress1("ts");
			haulierBean.setStreetAddress2("hs");
			haulierBean.setTown("palamaner");
			haulierBean.setPincode("517241");
			haulierBean.setEmail("bhaavan@gmail.com");
			haulierBean.setPhoneNumber("9550228395");
			boolean insertCheck = haulierDao.addHaulier(haulierBean);
			assertEquals(insertCheck, true);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()->{
				haulierDao.addHaulier(haulierBean);
			});
		}
	}

	@Test
	void testGetHaulier() {
		HaulierBean haulier = haulierDao.getHaulier("2222");
		assertNotNull(haulier);
	}

	@Test
	void testGetAllHauliers() {
		List<HaulierBean> hauliersList = haulierDao.getAllHauliers();
		assertNotNull(hauliersList);
	}

	@Test
	void testDeleteHaulier() {
		boolean deleteCheck = haulierDao.deleteHaulier("565");
		assertEquals(deleteCheck,false);
	}

	@Test
	void testUpdateHaulier() {
		haulierBean = new HaulierBean();
		haulierBean.setHaulierId("2221");
		haulierBean.setHaulierName("syamala");
		haulierBean.setStreetAddress1("sainagar");
		haulierBean.setStreetAddress2("street");
		haulierBean.setTown("vellor");
		haulierBean.setPincode("547125");
		haulierBean.setEmail("syamalab@gmail.com");
		haulierBean.setPhoneNumber("9550316616");
		boolean updateCheck = haulierDao.updateHaulier("2221", haulierBean);
		assertEquals(updateCheck, true);
	}

}
