package com.cg.forestmanagementspringrest.service;

import java.util.List;

import com.cg.forestmanagementspringrest.dto.HaulierBean;

public interface HaulierService {
	public boolean addHaulier(HaulierBean haulier);

	public HaulierBean getHaulier(int haulierId);

	public List<HaulierBean> getAllHauliers();

	public boolean deleteHaulier(int haulierId);

	public boolean updateHaulier(HaulierBean haulier);
}
