package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.ProductDao;
import com.cg.forestmanagementspringrest.dto.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public boolean addProduct(ProductBean product) {
		// TODO Auto-generated method stub
		return dao.addProduct(product);
	}

	@Override
	public ProductBean getProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.getProduct(productId);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(ProductBean product) {
		// TODO Auto-generated method stub
		return dao.updateProduct(product);
	}
}
