package com.cg.jpawithhibernateapp.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpawithhibernateapp.onetoone.EmployeeInfo;


public class TestOneToMany {

	public static void main(String[] args) {
//		EmployeeInfo emp=new EmployeeInfo();
//	    emp.setEmpid(11);
//	    emp.setEmpname("Ram");
//	    emp.setEmail("ram@gmail.com");
//	    emp.setPassword("johnpwd");
	   /* EmployeeExperience experience=new EmployeeExperience();
	    experience.setExpid(111);
	    experience.setCompany("abc");
	    experience.setNoofyears(2);
	    experience.setEmp(emp);
	    EmployeeExperience experience1=new EmployeeExperience();
	    experience1.setExpid(112);
	    experience1.setCompany("def");
	    experience1.setNoofyears(1);
	    experience1.setEmp(emp);*/
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			EmployeeInfo emp1=entityManager.find(EmployeeInfo.class,10);
			EmployeeExperience experience2=new EmployeeExperience();
		    experience2.setExpid(155);
		    experience2.setCompany("kjhgfx");
		    experience2.setNoofyears(2);
		    experience2.setEmp(emp1);
		    entityManager.persist(experience2);
//		    entityManager.persist(experience1);
//			entityManager.persist(experience);
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


