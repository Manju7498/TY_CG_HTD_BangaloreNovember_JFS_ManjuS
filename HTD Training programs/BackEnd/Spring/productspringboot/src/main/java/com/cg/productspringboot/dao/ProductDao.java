package com.cg.productspringboot.dao;

import java.util.List;

import com.cg.productspringboot.dto.ProductBean;

public interface ProductDao {
public boolean addProduct(ProductBean product);
	
	public ProductBean getProduct(int id);
	
	public List<ProductBean> getAllProducts();
	
	public boolean deleteProduct(int id);
}
