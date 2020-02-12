package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.HaulierBean;

public interface HaulierService {
	public List<HaulierBean> getAllHauliers();

	public HaulierBean haulierLogin(int haulierId);

	public boolean insertHaulier(HaulierBean haulier);

	public boolean deleteHaulier(int haulierId);

	public boolean updateHaulier(int haulierId, HaulierBean haulier);
}
