package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.HaulierBean;

public interface HaulierDao {
	public List<HaulierBean> getAllHauliers();

	public HaulierBean haulierLogin(int haulierId);

	public boolean insertHaulier(HaulierBean haulier);

	public boolean deleteHaulier(int haulierId);

	public boolean updateHaulier(int haulierId, HaulierBean haulier);
}
