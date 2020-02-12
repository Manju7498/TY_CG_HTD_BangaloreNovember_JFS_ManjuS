package com.cg.forestrymanagementjpa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjpa.bean.ProductBean;

class ProductServiceImplTest {
	public static ProductBean productBean;
	public static ProductService productService = new ProductServiceImpl();

	@Test
	void testGetAllProducts() {
		List<ProductBean> productsList = productService.getAllProducts();
		assertNotNull(productsList);
	}

	@Test
	void testProductLogin() {
		ProductBean product = productService.productLogin(1);
		assertNotNull(product);
	}

	@Test
	void testUpdateProductName() {
		productBean = new ProductBean();
		productBean.setProductId(1);
		productBean.setProductName("lotha");
		boolean insertCheck = productService.updateProductName(1,productBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testDeleteProduct() {
		boolean deleteCheck = productService.deleteProduct(6552);
		assertEquals(deleteCheck,false);
	}

	@Test
	void testInsertProduct() {
		productBean = new ProductBean();
		productBean.setProductId(8547);
		productBean.setProductName("priya");
		productBean.setProductOrderDate("21/02/2021");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean insertCheck = productService.insertProduct(productBean);
		assertEquals(insertCheck, false);	
	}
}
