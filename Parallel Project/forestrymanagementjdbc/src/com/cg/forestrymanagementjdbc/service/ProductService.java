package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.ProductBean;

public interface ProductService {
	public List<ProductBean> getAllProducts();

	public ProductBean productLogin(int productid);

	public boolean updateProduct(int productid, ProductBean bean);

	public boolean deleteProduct(int productid);

	public boolean insertProduct(ProductBean bean);
}
