package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.HaulierBean;

public interface HaulierDao {
	public boolean addHaulier(HaulierBean haulier);

	public HaulierBean getHaulier(String haulierId);

	public List<HaulierBean> getAllHauliers();

	public boolean deleteHaulier(String haulierId);

	public boolean updateHaulier(String haulierId,HaulierBean haulier);
}
