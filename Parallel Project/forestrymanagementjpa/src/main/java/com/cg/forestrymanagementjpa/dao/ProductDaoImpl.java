package com.cg.forestrymanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.forestrymanagementjpa.bean.ProductBean;
import com.cg.forestrymanagementjpa.exceptions.ForestryExceptions;

public class ProductDaoImpl implements ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("forestrymanagement");

	
	public List<ProductBean> getAllProducts() {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String getallProductsJpql = "from ProductBean";
			Query query = entityManager.createQuery(getallProductsJpql);
			@SuppressWarnings("unchecked")
			List<ProductBean> list = query.getResultList();
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	
	public ProductBean productLogin(int productId) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			@SuppressWarnings("unused")
			String getProductJpql = "from ProductBean where productId=:productId";
			ProductBean productBean=entityManager.find(ProductBean.class,productId);
			if (productBean != null) {
				return productBean;
			} 
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	
	public boolean updateProductName(int productId, ProductBean bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			ProductBean productBean = entityManager.find(ProductBean.class, bean.getProductId());
			transaction.begin();
			String updateProductJpql = "update ProductBean SET productName=:productName where productId=:productId";
			Query query = entityManager.createQuery(updateProductJpql);
			query.setParameter("productName", bean.getProductName());
			query.setParameter("productId", bean.getProductId());
			int isUpdatedName = query.executeUpdate();
			if (isUpdatedName > 0) {
				productBean.setProductName(bean.getProductName());
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}

	public boolean deleteProduct(int productId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String deleteProductJpql = "delete from ProductBean where productId=:productId";
			//ProductBean productBean1 = entityManager.find(ProductBean.class, productId);
			Query query = entityManager.createQuery(deleteProductJpql);
			query.setParameter("productId", productId);
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

	public boolean insertProduct(ProductBean bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			ProductBean productBean1 = entityManager.find(ProductBean.class, bean.getProductId());
			if (productBean1 == null) {
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

}
