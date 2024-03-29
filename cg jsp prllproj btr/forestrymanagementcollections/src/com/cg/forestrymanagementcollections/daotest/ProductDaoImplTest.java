package com.cg.forestrymanagementcollections.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementcollections.bean.ProductBean;
import com.cg.forestrymanagementcollections.dao.ProductDao;
import com.cg.forestrymanagementcollections.dao.ProductDaoImpl;

class ProductDaoImplTest {
	private ProductBean productBean=new ProductBean();
	private ProductDao productDao=new ProductDaoImpl();
	@BeforeEach
	void addProduct() {
		productBean.setProductId(8544);
		productBean.setProductName("grocery");
		productBean.setProductDeliveryDate("04/06/2020");
		productDao.addProduct(8544, productBean);
	}


	@Test
	void testDeleteProduct() {
		boolean result = productDao.deleteProduct(8544);
		assertEquals(result, true);
	}

	@Test
	void testGetProduct() {
		ProductBean result = productDao.getProduct(8544);
		assertNotNull(result);
	}

	@Test
	void testAddProduct() {
		productBean.setProductId(3244);
		productBean.setProductName("soap");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean result=productDao.addProduct(3244, productBean);
		assertEquals(result, true);
	}

	@Test
	void testGetAllProducts() {
		HashMap<Integer, ProductBean> result = productDao.getAllProducts();
		assertNotNull(result);
	}

	@Test
	void testUpdateProduct() {
		ProductBean product = new ProductBean();
		product.setProductId(8544);
		product.setProductName("timber");
		productDao.updateProduct(product.getProductId(), product);
	}

}
