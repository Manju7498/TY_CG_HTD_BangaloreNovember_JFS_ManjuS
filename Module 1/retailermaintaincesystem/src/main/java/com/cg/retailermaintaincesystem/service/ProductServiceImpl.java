package com.cg.retailermaintaincesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.retailermaintaincesystem.dao.ProductDao;
import com.cg.retailermaintaincesystem.dto.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public boolean addProduct(ProductBean product) {

		return dao.addProduct(product);
	}

	@Override
	public ProductBean getProduct(int productId) {
		return dao.getProduct(productId);
	}
}
