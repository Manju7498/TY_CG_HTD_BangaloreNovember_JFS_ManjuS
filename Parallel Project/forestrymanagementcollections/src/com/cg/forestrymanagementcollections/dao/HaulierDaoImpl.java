package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.forestrymanagementcollections.bean.HaulierBean;
import com.cg.forestrymanagementcollections.exceptions.ForestryExceptions;

public class HaulierDaoImpl implements HaulierDao {
	private HashMap<Integer, HaulierBean> haulierbeans = new HashMap<Integer, HaulierBean>();
	Set<Entry<Integer, HaulierBean>> s = haulierbeans.entrySet();
	HaulierBean haulier1 = new HaulierBean();

	@Override
	public boolean deleteHaulier(int haulierId) {
		for (Entry<Integer, HaulierBean> entry : s) {
			try {
				if (entry.getKey() == haulierId) {
					haulierbeans.remove(haulierId);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		try {
			if (haulierbeans.containsKey(haulierId) == true) {
				return haulierbeans.get(haulierId);
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public boolean addHaulier(int haulierId, HaulierBean haulier) {
		for (Entry<Integer, HaulierBean> entry : s) {
			try {
				if (entry.getKey() == haulierId) {
					return false;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		haulierbeans.put(haulierId, haulier);
		return true;
	}

	@Override
	public HashMap<Integer, HaulierBean> getAllHauliers() {
		for (Entry<Integer, HaulierBean> entry : s) {
			try {
				if (entry != null) {
					return haulierbeans;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return null;
	}

	@Override
	public boolean updateHaulier(int haulierId, HaulierBean haulier) {
		for (Entry<Integer, HaulierBean> entry : s) {
			try {
				if (entry.getKey() == haulierId) {
					haulierbeans.replace(haulierId, haulier);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}
}
