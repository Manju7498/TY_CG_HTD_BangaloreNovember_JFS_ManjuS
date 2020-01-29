package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.HaulierBean;
import com.cg.forestrymanagementcollections.dao.HaulierDao;
import com.cg.forestrymanagementcollections.factory.HaulierFactory;

public class HaulierServiceImpl implements HaulierService {
	HaulierDao dao = HaulierFactory.instanceofHaulierDaoImpl();

	@Override
	public HashMap<Integer, HaulierBean> getAllHauliers() {
		return dao.getAllHauliers();
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		return dao.getHaulier(haulierId);
	}

	@Override
	public boolean addHaulier(int haulierId, HaulierBean haulier) {
		return dao.addHaulier(haulierId, haulier);
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		return dao.deleteHaulier(haulierId);
	}

	@Override
	public boolean updateHaulier(int haulierId, HaulierBean haulier) {
		return dao.updateHaulier(haulierId, haulier);
	}
}
