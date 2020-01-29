package com.cg.forestrymanagementjdbc.factory;

import com.cg.forestrymanagementjdbc.dao.ProductDao;
import com.cg.forestrymanagementjdbc.dao.ProductDaoImpl;
import com.cg.forestrymanagementjdbc.service.ProductService;
import com.cg.forestrymanagementjdbc.service.ProductServiceImpl;

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
