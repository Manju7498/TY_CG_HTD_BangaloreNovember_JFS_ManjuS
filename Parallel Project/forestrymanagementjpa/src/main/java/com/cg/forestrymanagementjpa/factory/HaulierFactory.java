package com.cg.forestrymanagementjpa.factory;

import com.cg.forestrymanagementjpa.dao.HaulierDao;
import com.cg.forestrymanagementjpa.dao.HaulierDaoImpl;
import com.cg.forestrymanagementjpa.service.HaulierService;
import com.cg.forestrymanagementjpa.service.HaulierServiceImpl;

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
