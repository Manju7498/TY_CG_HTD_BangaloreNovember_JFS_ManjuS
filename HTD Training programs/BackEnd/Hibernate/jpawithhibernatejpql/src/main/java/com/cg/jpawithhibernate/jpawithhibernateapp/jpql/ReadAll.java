package com.cg.jpawithhibernate.jpawithhibernateapp.jpql;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.cg.jpawithhibernate.jpawithhibernateapp.dto.Movie;

public class ReadAll {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		/*String jpql="from Movie";
		Query query=entityManager.createQuery(jpql);
		List<Movie> record=query.getResultList();
		for (Movie movie : record) {
			System.out.println("Movie id : "+list.getMid());
			System.out.println("Movie name : "+list.getMname());
			System.out.println("Movie ratings : "+list.getRating());
			System.out.println("*********************************");*/
		/*String jpql="Select mname from Movie";
		Query query=entityManager.createQuery(jpql);
		List<String> list=query.getResultList();
		for (String movie : list) {
			System.out.println();
			System.out.println(movie);
		}*/
		//String jpql="from Movie where mid=101";
		String jpql="from Movie where mid=:mid";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("mid",105);
		Movie list=(Movie) query.getSingleResult();
		if(list!=null) {
			System.out.println("movie id :"+list.getMid());
			System.out.println("movie name : "+list.getMname());
			System.out.println("rating : "+list.getRating());
		}
		
	}

}
