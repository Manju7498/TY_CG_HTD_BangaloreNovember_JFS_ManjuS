package com.cg.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.forestrymanagementspringboot.dto.ProductBean;

@SpringBootTest
class ProductServiceImplTest {
	
		@Autowired
		public ProductService productService;
		ProductBean productBean;

		@Test
		void testAddProduct() {
			productBean = new ProductBean();
			productBean.setProductId("3334");
			productBean.setProductName("priya");
			productBean.setProductQuantity("3000");
			productBean.setProductDeliveryDate("2020-05-04");
			boolean insertCheck = productService.addProduct(productBean);
			assertEquals(insertCheck,true);
		}

		@Test
		void testGetProduct() {
			ProductBean product = productService.getProduct("3331");
			assertNotNull(product);
		}

		@Test
		void testGetAllProducts() {
			List<ProductBean> productsList = productService.getAllProducts();
			assertNotNull(productsList);
		}

		@Test
		void testDeleteProduct() {
			boolean deleteCheck = productService.deleteProduct("1");
			assertEquals(deleteCheck,false);
		}

		@Test
		void testUpdateProduct() {
			productBean = new ProductBean();
			productBean.setProductId("3331");
			productBean.setProductName("latha");
			productBean.setProductDeliveryDate("2020-04-02");
			productBean.setProductQuantity("7000");
			boolean insertCheck = productService.updateProduct("3331",productBean);
			assertEquals(insertCheck, true);
		}

}
