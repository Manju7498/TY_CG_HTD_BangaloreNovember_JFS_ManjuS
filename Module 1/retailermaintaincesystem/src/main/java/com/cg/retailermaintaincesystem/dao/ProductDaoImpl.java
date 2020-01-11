package com.cg.retailermaintaincesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.cg.retailermaintaincesystem.dto.ProductBean;

@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductBean getProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		ProductBean product = manager.find(ProductBean.class, productId);
		return product;
	}

	@Override
	public boolean addProduct(ProductBean product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
