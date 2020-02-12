package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

public class HaulierDaoImpl implements HaulierDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("forestrymanagement");
	EntityManager entityManager = null;
	EntityTransaction transaction = null;
	
	public List<HaulierBean> getAllHauliers() {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String getallHauliersJpql = "from HaulierBean";
			Query query = entityManager.createQuery(getallHauliersJpql);
			@SuppressWarnings("unchecked")
			List<HaulierBean> list = query.getResultList();
			if (!list.isEmpty()) {
				return list;
			} 
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	
	public boolean deleteHaulier(int haulierId) {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String deleteHaulierJpql = "delete from HaulierBean where haulierId=:haulierId";
			//HaulierBean haulierBean1 = entityManager.find(HaulierBean.class, haulierId);
			Query query = entityManager.createQuery(deleteHaulierJpql);
			query.setParameter("haulierId", haulierId);
			int isDeleted = query.executeUpdate();
			if (isDeleted > 0) {
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return false;
	}

	public boolean insertHaulier(HaulierBean bean) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			HaulierBean haulierBean1 = entityManager.find(HaulierBean.class, bean.getHaulierId());
			if (haulierBean1 == null) {
				transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(bean);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		entityManager.close();
		return false;
	}

	public HaulierBean haulierLogin(int haulierId) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			HaulierBean haulierBean = entityManager.find(HaulierBean.class, haulierId);
			if (haulierBean != null) {
				return haulierBean;
			} 
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	public boolean updateHaulier(int haulierId, HaulierBean bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			HaulierBean haulierBean = entityManager.find(HaulierBean.class, haulierId);
			transaction.begin();
			String updateHaulierJpql = "update HaulierBean SET haulierName=:haulierName,email=:email where haulierId=:haulierId";
			Query query = entityManager.createQuery(updateHaulierJpql);
			query.setParameter("haulierName", bean.getHaulierName());
			query.setParameter("email", bean.getEmail());
			query.setParameter("haulierId", haulierId);
			int isUpdatedName = query.executeUpdate();
			if (isUpdatedName > 0) {
				haulierBean.setHaulierName(bean.getHaulierName());
				haulierBean.setEmail(bean.getEmail());
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}
}
