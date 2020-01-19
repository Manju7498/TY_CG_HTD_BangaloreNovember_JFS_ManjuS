package com.cg.forestmanagementspringrest.service;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean product);

	public ProductBean getProduct(int productId);

	public List<ProductBean> getAllProducts();

	public boolean deleteProduct(int productId);

	public boolean updateProduct(ProductBean product);
}
