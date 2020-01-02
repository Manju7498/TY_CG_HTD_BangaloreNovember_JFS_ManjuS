package com.cg.jpawithhibernateapp.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpawithhibernateapp.onetoone.EmployeeInfo;

public class TestManyToMany {

	public static void main(String[] args) {
		EmployeeInfo emp=new EmployeeInfo();
	    emp.setEmpid(30);
	    emp.setEmpname("Uday");
	    emp.setEmail("uday@gmail.com");
	    emp.setPassword("udaypwd");
	    EmployeeInfo emp1=new EmployeeInfo();
	    emp1.setEmpid(31);
	    emp1.setEmpname("Ajay");
	    emp1.setEmail("ajay@gmail.com");
	    emp.setPassword("ajaypwd");
	    ArrayList<EmployeeInfo> a=new ArrayList<EmployeeInfo>();
	    a.add(emp1);
	    a.add(emp);
	    Training_info tinfo=new Training_info();
	    tinfo.setTid(3333);
	    tinfo.setTname("JMS");
	    tinfo.setDuration(30);
	    tinfo.setListemployeeinfo(a);
	    EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(tinfo);
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
