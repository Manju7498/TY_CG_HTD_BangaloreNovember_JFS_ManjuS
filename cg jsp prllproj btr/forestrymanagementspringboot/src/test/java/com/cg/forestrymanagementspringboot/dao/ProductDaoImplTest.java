package com.cg.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.ProductBean;
@SpringBootTest
class ProductDaoImplTest {
	@Autowired
	public ProductDao productDao;
	ProductBean productBean;

	@Test
	void testAddProduct() {
		productBean = new ProductBean();
		productBean.setProductId("3333");
		productBean.setProductName("priya");
		productBean.setProductQuantity("5000");
		productBean.setProductDeliveryDate("2020-04-06");
		boolean insertCheck = productDao.addProduct(productBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testGetProduct() {
		ProductBean product = productDao.getProduct("");
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
		productBean.setProductId("3331");
		productBean.setProductName("latha");
		productBean.setProductDeliveryDate("2020-04-02");
		productBean.setProductQuantity("5000");
		boolean insertCheck = productDao.updateProduct("3331",productBean);
		assertEquals(insertCheck, true);
	}

}
