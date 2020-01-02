package com.cg.jpawithhibernateapp.onetoone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOne {
	public static void main(String[] args) {
	    /*EmployeeInfo emp=new EmployeeInfo();
	    emp.setEmpid(10);
	    emp.setEmpname("John");
	    emp.setEmail("john@gmail.com");
	    emp.setPassword("johnpwd");
	    EmployeeOtherInfo other=new EmployeeOtherInfo();
	    other.setId(1);
	    other.setPancard(3456);
	    other.setFname("fjohn");
	    other.setMname("mjohn");
	    other.setEmpInfo(emp);*/
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			//entityManager.persist(other);
			EmployeeInfo emp=entityManager.find(EmployeeInfo.class,10);
		wrong	//EmployeeInfo emp=new EmployeeInfo();
			//EmployeeOtherInfo other=new EmployeeOtherInfo();
			//System.out.println("Emp name : "+emp.get);
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
