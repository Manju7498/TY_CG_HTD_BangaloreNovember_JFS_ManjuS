package com.cg.productspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.productspringboot.controller.Product;
import com.cg.productspringboot.dto.ProductBean;

@Repository
public class ProductDaoImpl implements ProductDao {
		@PersistenceUnit
		EntityManagerFactory factory;
		
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

		@Override
		public ProductBean getProduct(int id) {
			EntityManager manager = factory.createEntityManager();
			ProductBean product=manager.find(ProductBean.class, id);
			return product;
		}

		@Override
		public List<ProductBean> getAllProducts() {
			EntityManager manager = factory.createEntityManager();
			String getall="from Product";
			TypedQuery<ProductBean> query=manager.createQuery(getall,ProductBean.class);
			return query.getResultList();
		}

		@Override
		public boolean deleteProduct(int id) {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			Product product = manager.find(Product.class, id);
			if(product!=null) {
				transaction.begin();
				manager.remove(product);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		}
}
