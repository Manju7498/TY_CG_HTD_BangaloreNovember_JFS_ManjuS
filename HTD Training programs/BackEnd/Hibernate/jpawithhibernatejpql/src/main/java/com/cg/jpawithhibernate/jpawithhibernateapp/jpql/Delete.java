package com.cg.jpawithhibernate.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		//String jpql3="Delete from Movie where mid=103";
		String jpql3="Delete from Movie where mid=:id";
		Query query=entityManager.createQuery(jpql3);
		query.setParameter("id",104);
		int report=query.executeUpdate();
		transaction.commit();
		if(report>0) {
			System.out.println(report+" Query deleted");
		}else {
			System.out.println("we r not able to delete the query");
		}
	}

}
