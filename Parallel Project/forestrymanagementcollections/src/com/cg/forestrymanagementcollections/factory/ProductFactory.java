package com.cg.forestrymanagementcollections.factory;

import com.cg.forestrymanagementcollections.dao.ProductDao;
import com.cg.forestrymanagementcollections.dao.ProductDaoImpl;
import com.cg.forestrymanagementcollections.service.ProductService;
import com.cg.forestrymanagementcollections.service.ProductServiceImpl;

public class ProductFactory {
	private ProductFactory() {

	}

	public static ProductDao instanceofProductDaoImpl() {
		ProductDao dao = new ProductDaoImpl();
		return dao;
	}

	public static ProductService instanceofProductServices() {
		ProductService services = new ProductServiceImpl();
		return services;
	}
}
