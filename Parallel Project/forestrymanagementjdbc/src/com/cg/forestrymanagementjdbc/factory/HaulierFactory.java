package com.cg.forestrymanagementjdbc.factory;

import com.cg.forestrymanagementjdbc.dao.HaulierDao;
import com.cg.forestrymanagementjdbc.dao.HaulierDaoImpl;
import com.cg.forestrymanagementjdbc.service.HaulierService;
import com.cg.forestrymanagementjdbc.service.HaulierServiceImpl;

public class HaulierFactory {
	private HaulierFactory() {

	}

	public static HaulierDao instanceofHaulierDaoImpl() {
		HaulierDao dao = new HaulierDaoImpl();
		return dao;
	}

	public static HaulierService instanceofHaulierServices() {
		HaulierService services = new HaulierServiceImpl();
		return services;
	}
}
