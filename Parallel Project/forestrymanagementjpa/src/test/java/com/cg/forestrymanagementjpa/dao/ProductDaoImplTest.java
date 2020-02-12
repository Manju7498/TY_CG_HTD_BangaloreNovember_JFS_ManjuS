package com.cg.forestrymanagementjpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.ProductBean;

class ProductDaoImplTest {
	public static ProductBean productBean;
	public static ProductDao productDao = new ProductDaoImpl();

	@Test
	void testGetAllProducts() {
		List<ProductBean> productsList = productDao.getAllProducts();
		assertNotNull(productsList);
	}

	@Test
	void testProductLogin() {
		ProductBean product = productDao.productLogin(1);
		assertNotNull(product);
	}

	@Test
	void testUpdateProductName() {
		productBean = new ProductBean();
		productBean.setProductId(1);
		productBean.setProductName("lotha");
		boolean insertCheck = productDao.updateProductName(1,productBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testDeleteProduct() {
		boolean deleteCheck = productDao.deleteProduct(9854);
		assertEquals(deleteCheck,true);
	}

	@Test
	void testInsertProduct() {
		productBean = new ProductBean();
		productBean.setProductId(6552);
		productBean.setProductName("priya");
		productBean.setProductOrderDate("21/02/2021");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean insertCheck = productDao.insertProduct(productBean);
		assertEquals(insertCheck, false);	
	}

	@BeforeAll
	@Test
	static void testInsertProductDuplicate() {
		productBean = new ProductBean();
		productBean.setProductId(9854);
		productBean.setProductName("priya");
		productBean.setProductOrderDate("21/02/2021");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean insertCheck = productDao.insertProduct(productBean);
		assertEquals(insertCheck, true);
	}
}
