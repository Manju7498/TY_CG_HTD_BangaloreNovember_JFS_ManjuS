package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.ProductBean;

public interface ProductService {
	public HashMap<Integer, ProductBean> getAllProducts();

	public ProductBean getProduct(int productId);

	public boolean addProduct(int productId, ProductBean product);

	public boolean deleteProduct(int productId);

	public boolean updateProduct(int productId, ProductBean product);
}
