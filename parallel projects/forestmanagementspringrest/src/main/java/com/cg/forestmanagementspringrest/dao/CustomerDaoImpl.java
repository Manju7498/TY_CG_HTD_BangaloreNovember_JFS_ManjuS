package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.forestmanagementspringrest.dto.CustomerBean;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addCustomer(CustomerBean customer) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(customer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		EntityManager manager = factory.createEntityManager();
		CustomerBean customer = manager.find(CustomerBean.class, customerId);
		return customer;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		EntityManager manager = factory.createEntityManager();
		String getall = "from CustomerBean";
		TypedQuery<CustomerBean> query = manager.createQuery(getall, CustomerBean.class);
		return query.getResultList();
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		CustomerBean customer = manager.find(CustomerBean.class, customerId);
		if (customer != null) {
			transaction.begin();
			manager.remove(customer);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateCustomer(CustomerBean customer) {
		EntityManager manager = factory.createEntityManager();
		CustomerBean customer1 = manager.find(CustomerBean.class, customer.getCustomerId());
		EntityTransaction transaction = manager.getTransaction();
		if (customer1 != null) {
			transaction.begin();
			customer1.setCustomerName(customer.getCustomerName());
			customer1.setStreetAddress1(customer.getStreetAddress1());
			customer1.setStreetAddress2(customer.getStreetAddress2());
			customer1.setTown(customer.getTown());
			customer1.setPincode(customer.getPincode());
			customer1.setEmail(customer.getEmail());
			customer1.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}
}
