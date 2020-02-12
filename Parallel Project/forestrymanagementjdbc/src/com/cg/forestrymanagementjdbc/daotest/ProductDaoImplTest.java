package com.cg.forestrymanagementjdbc.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.forestrymanagementjdbc.bean.ProductBean;
import com.cg.forestrymanagementjdbc.dao.ProductDao;
import com.cg.forestrymanagementjdbc.dao.ProductDaoImpl;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;

class ProductDaoImplTest {
	private ProductBean productBean=new ProductBean();
	private  ProductDao productDao = new ProductDaoImpl();


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
	void testUpdateProduct() {
		productBean = new ProductBean();
		productBean.setProductId(1);
		productBean.setProductName("latha");
		boolean insertCheck = productDao.updateProduct(1,productBean);
		assertEquals(insertCheck, true);
	}

	@Test
	void testDeleteProduct() {
		boolean deleteCheck = productDao.deleteProduct(9854);
		assertEquals(deleteCheck,false);
	}

	@Test
	void testInsertProduct() {
		try {
		productBean.setProductId(987);
		productBean.setProductName("priya");
		productBean.setProductOrderDate("21/02/2021");
		productBean.setProductDeliveryDate("06/04/2020");
		boolean insertCheck = productDao.insertProduct(productBean);
		assertEquals(insertCheck, true);
		}catch (Exception e) {
			assertThrows(ForestryExceptions.class, ()-> {
				productDao.insertProduct(productBean);
			});
		}
	}

}
