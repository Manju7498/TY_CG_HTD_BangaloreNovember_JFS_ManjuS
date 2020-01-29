package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.dao.HaulierDao;
import com.cg.forestrymanagementjpa.factory.HaulierFactory;

public class HaulierServiceImpl implements HaulierService {
	HaulierDao dao = HaulierFactory.instanceofHaulierDaoImpl();

	public List<HaulierBean> getAllHauliers() {
		// TODO Auto-generated method stub
		return dao.getAllHauliers();
	}

	public HaulierBean haulierLogin(int haulierId) {
		// TODO Auto-generated method stub
		return dao.haulierLogin(haulierId);
	}

	public boolean insertHaulier(HaulierBean haulier) {
		// TODO Auto-generated method stub
		return dao.insertHaulier(haulier);
	}

	public boolean deleteHaulier(int haulierId) {
		// TODO Auto-generated method stub
		return dao.deleteHaulier(haulierId);
	}

	public boolean updateHaulier(int haulierId, HaulierBean haulier) {
		// TODO Auto-generated method stub
		return dao.updateHaulier(haulierId, haulier);
	}

	
}
