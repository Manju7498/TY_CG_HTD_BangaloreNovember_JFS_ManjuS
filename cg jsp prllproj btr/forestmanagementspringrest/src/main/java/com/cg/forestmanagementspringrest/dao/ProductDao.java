package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean product);

	public ProductBean getProduct(String productId);

	public List<ProductBean> getAllProducts();

	public boolean deleteProduct(String productId);

	public boolean updateProduct(String productId,ProductBean product);
}
