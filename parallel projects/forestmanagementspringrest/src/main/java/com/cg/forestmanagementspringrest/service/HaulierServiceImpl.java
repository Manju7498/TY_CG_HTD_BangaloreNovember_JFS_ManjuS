package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.HaulierDao;
import com.cg.forestmanagementspringrest.dto.HaulierBean;

@Service
public class HaulierServiceImpl implements HaulierService {
	@Autowired
	private HaulierDao dao;

	@Override
	public boolean addHaulier(HaulierBean haulier) {
		// TODO Auto-generated method stub
		return dao.addHaulier(haulier);
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		// TODO Auto-generated method stub
		return dao.getHaulier(haulierId);
	}

	@Override
	public List<HaulierBean> getAllHauliers() {
		// TODO Auto-generated method stub
		return dao.getAllHauliers();
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		// TODO Auto-generated method stub
		return dao.deleteHaulier(haulierId);
	}

	@Override
	public boolean updateHaulier(HaulierBean haulier) {
		// TODO Auto-generated method stub
		return dao.updateHaulier(haulier);
	}

}
