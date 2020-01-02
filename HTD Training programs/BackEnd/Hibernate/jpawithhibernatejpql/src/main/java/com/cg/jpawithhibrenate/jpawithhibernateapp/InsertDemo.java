package com.cg.jpawithhibrenate.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpawithhibernate.jpawithhibernateapp.dto.Movie;

public class InsertDemo {

	public static void main(String[] args) {
		Movie movie=new Movie();
		movie.setMid(105);
		movie.setMname("REMO");
		movie.setRating("Good");
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(movie);
			System.out.println("record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		//transaction.commit();
		entityManager.close();
	}

}
