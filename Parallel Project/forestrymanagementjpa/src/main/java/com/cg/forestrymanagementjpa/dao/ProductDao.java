package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.ProductBean;

public interface ProductDao {
	public List<ProductBean> getAllProducts();

	public ProductBean productLogin(int productid);

	public boolean updateProductName(int productId, ProductBean bean);

	public boolean deleteProduct(int productid);

	public boolean insertProduct(ProductBean bean);
}
