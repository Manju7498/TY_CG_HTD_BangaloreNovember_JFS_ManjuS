package com.cg.jpawithhibrenate.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpawithhibernate.jpawithhibernateapp.dto.Movie;

public class Reattaching {
	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		Movie record=entityManager.find(Movie.class,103);
		System.out.println(entityManager.contains(record));
		entityManager.detach(record);
		System.out.println(entityManager.contains(record));
		Movie reattach=entityManager.merge(record);
		System.out.println(entityManager.contains(reattach));
		reattach.setMname("KAALA");
		System.out.println("record update");
		transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
	}

}
