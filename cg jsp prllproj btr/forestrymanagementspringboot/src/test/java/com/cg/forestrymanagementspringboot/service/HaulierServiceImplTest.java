package com.cg.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.HaulierBean;
import com.cg.forestrymanagementspringboot.exceptions.ForestryExceptions;

@SpringBootTest
class HaulierServiceImplTest {
		@Autowired
		public HaulierService haulierService;
		HaulierBean haulierBean;
		@Test
		void testAddHaulier() {
			try {
				haulierBean = new HaulierBean();
				haulierBean.setHaulierId("2224");
				haulierBean.setHaulierName("priya");
				haulierBean.setStreetAddress1("ts");
				haulierBean.setStreetAddress2("hs");
				haulierBean.setTown("plmr");
				haulierBean.setPincode("517241");
				haulierBean.setEmail("bhaavan@gmail.com");
				haulierBean.setPhoneNumber("9550228395");
				boolean insertCheck = haulierService.addHaulier(haulierBean);
				assertEquals(insertCheck,true);
			}catch (Exception e) {
				assertThrows(ForestryExceptions.class, ()->{
					haulierService.addHaulier(haulierBean);
				});
			}
		}

		@Test
		void testGetHaulier() {
			HaulierBean haulier = haulierService.getHaulier("2222");
			assertNotNull(haulier);
		}

		@Test
		void testGetAllHauliers() {
			List<HaulierBean> hauliersList = haulierService.getAllHauliers();
			assertNotNull(hauliersList);
		}

		@Test
		void testDeleteHaulier() {
			boolean deleteCheck = haulierService.deleteHaulier("1");
			assertEquals(deleteCheck,false);
		}

		@Test
		void testUpdateHaulier() {
			haulierBean = new HaulierBean();
			haulierBean.setHaulierId("2222");
			haulierBean.setHaulierName("syamala");
			haulierBean.setStreetAddress1("sainagar");
			haulierBean.setStreetAddress2("street");
			haulierBean.setTown("vellor");
			haulierBean.setPincode("547125");
			haulierBean.setEmail("syamalab@gmail.com");
			haulierBean.setPhoneNumber("9550316616");
			boolean updateCheck = haulierService.updateHaulier("2222", haulierBean);
			assertEquals(updateCheck, true);
		}

	

}
