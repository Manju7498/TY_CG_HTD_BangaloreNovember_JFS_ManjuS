package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.ProductBean;
import com.cg.forestrymanagementcollections.dao.ProductDao;
import com.cg.forestrymanagementcollections.factory.ProductFactory;

public class ProductServiceImpl implements ProductService {
	ProductDao dao = ProductFactory.instanceofProductDaoImpl();

	@Override
	public HashMap<Integer, ProductBean> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public ProductBean getProduct(int productId) {
		return dao.getProduct(productId);
	}

	@Override
	public boolean addProduct(int productId, ProductBean product) {
		return dao.addProduct(productId, product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return dao.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(int productId, ProductBean product) {
		return dao.updateProduct(productId, product);
	}

}
