package com.cg.forestrymanagementjdbc.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.ProductBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;
import com.cg.forestrymanagementjdbc.service.ProductService;
import com.cg.forestrymanagementjdbc.service.ProductServiceImpl;

class ProductServiceImplTest {

	private ProductBean productBean=new ProductBean();
	private  ProductService productService = new ProductServiceImpl();


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
	void testUpdateProduct() {
		productBean = new ProductBean();
		productBean.setProductId(1);
		productBean.setProductName("latha");
		boolean insertCheck = productService.updateProduct(1,productBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testDeleteProduct() {
		boolean deleteCheck = productService.deleteProduct(9854);
		assertEquals(deleteCheck,false);
	}

	@Test
	void testInsertProduct() {
		try {
		productBean.setProductId(8754);
		productBean.setProductName("priya");
		productBean.setProductDeliveryDate("21/02/2021");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean insertCheck = productService.insertProduct(productBean);
		assertEquals(insertCheck, true);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				productService.insertProduct(productBean);
			});
		}
	}
}