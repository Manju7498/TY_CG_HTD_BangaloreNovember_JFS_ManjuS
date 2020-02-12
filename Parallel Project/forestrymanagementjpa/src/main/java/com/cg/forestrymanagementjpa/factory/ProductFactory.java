package com.cg.forestrymanagementjpa.factory;

import com.cg.forestrymanagementjpa.dao.ProductDao;
import com.cg.forestrymanagementjpa.dao.ProductDaoImpl;
import com.cg.forestrymanagementjpa.service.ProductService;
import com.cg.forestrymanagementjpa.service.ProductServiceImpl;

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
