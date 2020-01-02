                          package com.cg.jpawithhibrenate.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpawithhibernate.jpawithhibernateapp.dto.Movie;

public class GetReference {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Movie record=entityManager.find(Movie.class,106);
		Movie record=entityManager.getReference(Movie.class,108);
		System.out.println(record.getClass());
		System.out.println("Movie ID : "+record.getMid());
		System.out.println("Movie name : "+record.getMname());
		System.out.println("Movie rating : "+record.getRating());
		entityManager.close();
	}

}
