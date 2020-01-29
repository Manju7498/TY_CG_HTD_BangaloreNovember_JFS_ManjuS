package com.cg.forestrymanagementcollections.factory;

import com.cg.forestrymanagementcollections.dao.HaulierDao;
import com.cg.forestrymanagementcollections.dao.HaulierDaoImpl;
import com.cg.forestrymanagementcollections.service.HaulierService;
import com.cg.forestrymanagementcollections.service.HaulierServiceImpl;

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
