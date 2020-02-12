package com.cg.forestmanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.forestmanagementspringrest.config.ORMConfig;
import com.cg.forestmanagementspringrest.dto.ProductBean;
import com.cg.forestmanagementspringrest.testormconfig.SpringRestTestConfig;

@SpringJUnitConfig(classes = { SpringRestTestConfig.class, ORMConfig.class })
class ProductDaoImplTest {
	
	@Autowired
	public ProductDao productDao;

	ProductBean productBean;
	
	@Test
	void testAddProduct() {
		productBean = new ProductBean();
		productBean.setProductId("6552");
		productBean.setProductName("priya");
		productBean.setProductOrderDate("21/02/2021");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean insertCheck = productDao.addProduct(productBean);
		assertEquals(insertCheck, false);
	}

	@Test
	void testGetProduct() {
		ProductBean product = productDao.getProduct("333");
		assertNotNull(product);
	}

	@Test
	void testGetAllProducts() {
		List<ProductBean> productsList = productDao.getAllProducts();
		assertNotNull(productsList);
	}

	@Test
	void testDeleteProduct() {
		boolean deleteCheck = productDao.deleteProduct("9854");
		assertEquals(deleteCheck,false);
	}

	@Test
	void testUpdateProduct() {
		productBean = new ProductBean();
		productBean.setProductId("333");
		productBean.setProductName("latha");
		boolean insertCheck = productDao.updateProduct("333",productBean);
		assertEquals(insertCheck, true);
	}

}
