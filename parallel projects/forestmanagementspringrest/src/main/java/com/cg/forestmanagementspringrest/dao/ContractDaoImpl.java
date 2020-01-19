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
			return false;
		}
	}

	@Override
	public ContractBean getContract(int contractNo) {
		EntityManager manager = factory.createEntityManager();
		ContractBean contract = manager.find(ContractBean.class, contractNo);
		return contract;
	}

	@Override
	public List<ContractBean> getAllContracts() {
		EntityManager manager = factory.createEntityManager();
		String getall = "from ContractBean";
		TypedQuery<ContractBean> query = manager.createQuery(getall, ContractBean.class);
		return query.getResultList();
	}

	@Override
	public boolean deleteContract(int contractNo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ContractBean contract = manager.find(ContractBean.class, contractNo);
		if (contract != null) {
			transaction.begin();
			manager.remove(contract);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateContract(ContractBean contract) {
		EntityManager manager = factory.createEntityManager();
		ContractBean contract1 = manager.find(ContractBean.class, contract.getContractNo());
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
		} else {
			return false;
		}
	}

}