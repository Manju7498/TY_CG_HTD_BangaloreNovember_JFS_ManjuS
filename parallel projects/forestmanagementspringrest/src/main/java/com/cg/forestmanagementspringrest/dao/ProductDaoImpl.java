package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.forestmanagementspringrest.dto.ProductBean;

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
	public ProductBean getProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		ProductBean product = manager.find(ProductBean.class, productId);
		return product;
	}

	@Override
	public List<ProductBean> getAllProducts() {
		EntityManager manager = factory.createEntityManager();
		String getall = "from ProductBean";
		TypedQuery<ProductBean> query = manager.createQuery(getall, ProductBean.class);
		return query.getResultList();
	}

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ProductBean product = manager.find(ProductBean.class, productId);
		if (product != null) {
			transaction.begin();
			manager.remove(product);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateProduct(ProductBean product) {
		EntityManager manager = factory.createEntityManager();
		ProductBean product1 = manager.find(ProductBean.class, product.getProductId());
		EntityTransaction transaction = manager.getTransaction();
		if (product1 != null) {
			transaction.begin();
			product1.setProductName(product.getProductName());
			product1.setProductOrderDate(product.getProductOrderDate());
			product1.setProductDeliveryDate(product.getProductDeliveryDate());
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

}
