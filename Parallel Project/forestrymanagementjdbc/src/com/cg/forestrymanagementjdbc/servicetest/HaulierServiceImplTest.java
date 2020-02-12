package com.cg.forestrymanagementjdbc.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.HaulierBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;
import com.cg.forestrymanagementjdbc.service.HaulierService;
import com.cg.forestrymanagementjdbc.service.HaulierServiceImpl;

class HaulierServiceImplTest {
	private HaulierBean haulierBean = new HaulierBean();
	private HaulierService haulierService = new HaulierServiceImpl();

	@Test
	void testGetAllHauliers() {
		List<HaulierBean> hauliersList = haulierService.getAllHauliers();
		assertNotNull(hauliersList);
	}

	@Test
	void testHaulierLogin() {
		HaulierBean haulier = haulierService.haulierLogin(1);
		assertNotNull(haulier);
	}

	@Test
	void testUpdateHaulier() {
		haulierBean = new HaulierBean();
		haulierBean.setHaulierName("syamala");
		haulierBean.setEmail("syamalab@gmail.com");
		boolean updateCheck = haulierService.updateHaulier(1, haulierBean);
		assertEquals(updateCheck, true);
	}

	@Test
	void testDeleteHaulier() {
		boolean deleteCheck = haulierService.deleteHaulier(887);
		assertEquals(deleteCheck, false);
	}

	@Test
	void testInsertHaulier() {
		try {
			haulierBean = new HaulierBean();
			haulierBean.setHaulierId(545);
			haulierBean.setHaulierName("priya");
			haulierBean.setStreetAddress1("ts");
			haulierBean.setStreetAddress2("hs");
			haulierBean.setTown("palamaner");
			haulierBean.setPostcode(517408);
			haulierBean.setEmail("bhaavan@gmail.com");
			haulierBean.setPhonenumber(9550316616l);
			boolean insertCheck = haulierService.insertHaulier(haulierBean);
			assertEquals(insertCheck, true);
		} catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				haulierService.insertHaulier(haulierBean);
			});
		}
	}

	
}
