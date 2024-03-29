package com.cg.forestmanagementspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.forestmanagementspringrest.dto.ContractBean;

@Repository
public class ContractDaoImpl implements ContractDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addContract(ContractBean contract) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(contract);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public ContractBean getContract(String contractNo) {
		EntityManager manager = factory.createEntityManager();
		try {
			ContractBean contract = manager.find(ContractBean.class, contractNo);
			if (contract != null) {
				return contract;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<ContractBean> getAllContracts() {
		try {
			EntityManager manager = factory.createEntityManager();
			String getall = "from ContractBean";
			TypedQuery<ContractBean> query = manager.createQuery(getall, ContractBean.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteContract(String contractNo) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			ContractBean contract = manager.find(ContractBean.class, contractNo);
				transaction.begin();
				manager.remove(contract);
				transaction.commit();
				return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	@Override
	public boolean updateContract(String contractNo,ContractBean contract) {
		try {
			EntityManager manager = factory.createEntityManager();
			ContractBean contract1 = manager.find(ContractBean.class,contractNo);
			EntityTransaction transaction = manager.getTransaction();
			if (contract1 != null) {
				transaction.begin();
				contract1.setCustomerId(contract.getCustomerId());
				contract1.setProductId(contract.getProductId());
				contract1.setHaulierId(contract.getHaulierId());
				contract1.setDeliveryDate(contract.getDeliveryDate());
				contract1.setDeliveryDay(contract.getDeliveryDay());
				contract1.setQuantity(contract.getQuantity());
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
