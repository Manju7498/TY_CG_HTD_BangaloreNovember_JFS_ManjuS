package com.cg.jpawithhibernate.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		//String jpql2="update Movie set mname='KAALA' where mname='KANA'";
		String jpql2="update Movie set mname=:newmn where mname=:oldmn";
		Query query=entityManager.createQuery(jpql2);
		query.setParameter("newmn","VIVEKAM");
		query.setParameter("oldmn", "BIGIL");
		int report=query.executeUpdate();
		transaction.commit();
		if(report>0) {
			System.out.println(report+" query updated");
		}else {
			System.out.println("query not updated");
		}
	}

}
