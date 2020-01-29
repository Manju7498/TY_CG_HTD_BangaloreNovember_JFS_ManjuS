package com.cg.forestrymanagementjdbc.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.HaulierBean;
import com.cg.forestrymanagementjdbc.dao.HaulierDao;
import com.cg.forestrymanagementjdbc.dao.HaulierDaoImpl;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;

class HaulierDaoImplTest {
	private HaulierBean haulierBean = new HaulierBean();
	private HaulierDao haulierDao = new HaulierDaoImpl();

	@Test
	void testGetAllHauliers() {
		List<HaulierBean> hauliersList = haulierDao.getAllHauliers();
		assertNotNull(hauliersList);
	}

	@Test
	void testHaulierLogin() {
		HaulierBean haulier = haulierDao.haulierLogin(1);
		assertNotNull(haulier);
	}

	@Test
	void testUpdateHaulier() {
		haulierBean = new HaulierBean();
		haulierBean.setHaulierName("syamala");
		haulierBean.setEmail("syamalab@gmail.com");
		boolean updateCheck = haulierDao.updateHaulier(1, haulierBean);
		assertEquals(updateCheck, true);
	}

	@Test
	void testDeleteHaulier() {
		boolean deleteCheck = haulierDao.deleteHaulier(887);
		assertEquals(deleteCheck, false);
	}

	@Test
	void testInsertHaulier() {
		try {
			haulierBean = new HaulierBean();
			haulierBean.setHaulierId(874);
			haulierBean.setHaulierName("priya");
			haulierBean.setStreetAddress1("ts");
			haulierBean.setStreetAddress2("hs");
			haulierBean.setTown("palamaner");
			haulierBean.setPostcode(517408);
			haulierBean.setEmail("bhaavan@gmail.com");
			haulierBean.setPhonenumber(9550316616l);
			boolean insertCheck = haulierDao.insertHaulier(haulierBean);
			assertEquals(insertCheck, true);
		} catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				haulierDao.insertHaulier(haulierBean);
			});
		}
	}

	

}
