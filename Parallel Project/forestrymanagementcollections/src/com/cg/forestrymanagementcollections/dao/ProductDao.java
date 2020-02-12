package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.ProductBean;

public interface ProductDao {
	public HashMap<Integer, ProductBean> getAllProducts();

	public ProductBean getProduct(int productId);

	public boolean addProduct(int productId, ProductBean product);

	public boolean deleteProduct(int productId);

	public boolean updateProduct(int productId, ProductBean product);
}
