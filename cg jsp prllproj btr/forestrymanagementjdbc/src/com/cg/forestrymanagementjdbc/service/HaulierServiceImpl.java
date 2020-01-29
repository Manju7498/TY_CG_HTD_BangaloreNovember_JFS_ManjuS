package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.HaulierBean;
import com.cg.forestrymanagementjdbc.dao.HaulierDao;
import com.cg.forestrymanagementjdbc.factory.HaulierFactory;

public class HaulierServiceImpl implements HaulierService {
	HaulierDao dao = HaulierFactory.instanceofHaulierDaoImpl();

	@Override
	public List<HaulierBean> getAllHauliers() {
		// TODO Auto-generated method stub
		return dao.getAllHauliers();
	}

	@Override
	public HaulierBean haulierLogin(int haulierId) {
		// TODO Auto-generated method stub
		return dao.haulierLogin(haulierId);
	}

	@Override
	public boolean insertHaulier(HaulierBean haulier) {
		// TODO Auto-generated method stub
		return dao.insertHaulier(haulier);
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		// TODO Auto-generated method stub
		return dao.deleteHaulier(haulierId);
	}

	@Override
	public boolean updateHaulier(int haulierId, HaulierBean haulier) {
		// TODO Auto-generated method stub
		return dao.updateHaulier(haulierId, haulier);
	}
}
