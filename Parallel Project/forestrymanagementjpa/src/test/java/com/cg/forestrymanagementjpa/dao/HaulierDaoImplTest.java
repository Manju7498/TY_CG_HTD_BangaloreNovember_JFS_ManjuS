package com.cg.forestrymanagementjpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

class HaulierDaoImplTest {
	public static HaulierBean haulierBean;
	public static HaulierDao haulierDao = new HaulierDaoImpl();

	@Test
	void testGetAllHauliers() {
		List<HaulierBean> hauliersList = haulierDao.getAllHauliers();
		assertNotNull(hauliersList);
	}

	@Test
	void testDeleteHaulier() {
		boolean deleteCheck = haulierDao.deleteHaulier(87);
		assertEquals(deleteCheck,true);
	}
	@BeforeAll
	@Test
	static void testInsertHaulierDuplicate() {
		try {
		haulierBean = new HaulierBean();
		haulierBean.setHaulierId(874);
		haulierBean.setHaulierName("priya");
		haulierBean.setStreetAddress1("ts");
		haulierBean.setStreetAddress2("hs");
		haulierBean.setTown("palamaner");
		haulierBean.setPincode(517408);
		haulierBean.setEmail("bhaavan@gmail.com");
		haulierBean.setPhoneNumber(9550316616l);
		boolean insertCheck = haulierDao.insertHaulier(haulierBean);
		assertEquals(insertCheck, false);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()->{
				haulierDao.insertHaulier(haulierBean);
			});
		}
	}

	@Test
	void testInsertHaulier() {
		try {
			haulierBean = new HaulierBean();
			haulierBean.setHaulierId(544);
			haulierBean.setHaulierName("priya");
			haulierBean.setStreetAddress1("ts");
			haulierBean.setStreetAddress2("hs");
			haulierBean.setTown("palamaner");
			haulierBean.setPincode(517408);
			haulierBean.setEmail("bhaavan@gmail.com");
			haulierBean.setPhoneNumber(9550228395l);
			boolean insertCheck = haulierDao.insertHaulier(haulierBean);
			assertEquals(insertCheck, false);
			}catch (Exception e) {
				assertThrows(ForestryExceptions.class, ()->{
					haulierDao.insertHaulier(haulierBean);
				});
			}
	}

	@Test
	void testHaulierLogin() {
		HaulierBean haulier = haulierDao.haulierLogin(544);
		assertNotNull(haulier);
	}

	@Test
	void testUpdateHaulier() {
		haulierBean = new HaulierBean();
		haulierBean.setHaulierName("syamala");
		haulierBean.setStreetAddress1("sainagar");
		haulierBean.setStreetAddress2("street");
		haulierBean.setTown("vellore");
		haulierBean.setPincode(547125);
		haulierBean.setEmail("syamalab@gmail.com");
		haulierBean.setPhoneNumber(9550316616l);
		boolean updateCheck = haulierDao.updateHaulier(2, haulierBean);
		assertEquals(updateCheck, true);
	}

}
