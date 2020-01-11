package com.cg.retailermaintaincesystem.dao;

import com.cg.retailermaintaincesystem.dto.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean product);
	
	public ProductBean getProduct(int productId);
}
