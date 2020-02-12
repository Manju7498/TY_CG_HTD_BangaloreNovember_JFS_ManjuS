package com.cg.forestrymanagementjpa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

class HaulierServiceImplTest {

	public static HaulierBean haulierBean;
	public static HaulierService haulierService = new HaulierServiceImpl();

	@Test
	void testGetAllHauliers() {
		List<HaulierBean> hauliersList = haulierService.getAllHauliers();
		assertNotNull(hauliersList);
	}

	@Test
	void testDeleteHaulier() {
		boolean deleteCheck = haulierService.deleteHaulier(874);
		assertEquals(deleteCheck,false);
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
			boolean insertCheck = haulierService.insertHaulier(haulierBean);
			assertEquals(insertCheck, true);
			}catch (Exception e) {
				assertThrows(ForestryExceptions.class, ()->{
					haulierService.insertHaulier(haulierBean);
				});
			}
	}

	@Test
	void testHaulierLogin() {
		HaulierBean haulier = haulierService.haulierLogin(2);
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
		boolean updateCheck = haulierService.updateHaulier(2, haulierBean);
		assertEquals(updateCheck, true);
	}


}
