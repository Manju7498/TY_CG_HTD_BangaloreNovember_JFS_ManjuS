package com.cg.forestrymanagementcollections.service;

import java.util.HashMap;

import com.cg.forestrymanagementcollections.bean.HaulierBean;

public interface HaulierService {
	public HashMap<Integer, HaulierBean> getAllHauliers();

	public HaulierBean getHaulier(int haulierId);

	public boolean addHaulier(int haulierId, HaulierBean haulier);

	public boolean deleteHaulier(int haulierId);

	public boolean updateHaulier(int haulierId, HaulierBean haulier);

}
