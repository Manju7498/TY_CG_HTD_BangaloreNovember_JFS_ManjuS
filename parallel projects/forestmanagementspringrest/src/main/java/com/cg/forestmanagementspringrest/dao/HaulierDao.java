package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.HaulierBean;

public interface HaulierDao {
	public boolean addHaulier(HaulierBean haulier);

	public HaulierBean getHaulier(int haulierId);

	public List<HaulierBean> getAllHauliers();

	public boolean deleteHaulier(int haulierId);

	public boolean updateHaulier(HaulierBean haulier);
}
