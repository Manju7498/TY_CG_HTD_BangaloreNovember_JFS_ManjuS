package com.cg.retailermaintaincesystem.service;

import com.cg.retailermaintaincesystem.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean product);

	public ProductBean getProduct(int productId);
}
