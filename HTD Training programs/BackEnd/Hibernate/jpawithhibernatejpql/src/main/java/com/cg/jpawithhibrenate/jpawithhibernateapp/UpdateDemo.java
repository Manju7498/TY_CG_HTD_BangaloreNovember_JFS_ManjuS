package com.cg.jpawithhibrenate.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpawithhibernate.jpawithhibernateapp.dto.Movie;

public class UpdateDemo {

	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		Movie record=entityManager.find(Movie.class,101);
		record.setMname("BIGIL");
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
