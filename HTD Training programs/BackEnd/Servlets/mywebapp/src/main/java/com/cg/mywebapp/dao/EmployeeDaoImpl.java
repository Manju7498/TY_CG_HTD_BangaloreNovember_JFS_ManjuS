package com.cg.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mywebapp.beans.EmployeeInfoBean;

public class EmployeeDaoImpl implements EmployeeDao {
	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("employeePersistenceUnit");

	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=entityManager.find(EmployeeInfoBean.class,empId);
		entityManager.close();
		return employeeInfoBean;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from EmployeeInfoBean where empId=:empId and password=:password";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("empId",empId);
		query.setParameter("password",password);
		EmployeeInfoBean employeeInfoBean=null;
		try {
			employeeInfoBean=(EmployeeInfoBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return employeeInfoBean;
	}//end of authenticate()

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		boolean isAdded=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=null;
		try {	
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(employeeInfoBean);
			transaction.commit();
			isAdded=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=entityManager.find(EmployeeInfoBean.class,empId);
		EntityTransaction transaction=null;
		if(employeeInfoBean!=null) {	
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(employeeInfoBean);
			transaction.commit();
			isDeleted=true;
		}
		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean existingEmployeeInfoBean=entityManager.find(EmployeeInfoBean.class,employeeInfoBean);
		EntityTransaction transaction=entityManager.getTransaction();
		if(existingEmployeeInfoBean!=null) {
			try {
				transaction.begin();
				String newName=employeeInfoBean.getEname().trim();
				if(newName!=null && !newName.isEmpty()) {
					existingEmployeeInfoBean.setEname(newName);
				}
				int newAge=employeeInfoBean.getAge();
				if(newAge>18) {
					existingEmployeeInfoBean.setAge(newAge);
				}
				double newSalary=employeeInfoBean.getSalary();
				if(newSalary>18) {
					existingEmployeeInfoBean.setSalary(newSalary);
				}
				String newDesignation=employeeInfoBean.getDesignation().trim();
				if(newDesignation!=null && !newDesignation.isEmpty()) {
					existingEmployeeInfoBean.setDesignation(newDesignation);
				}
				String newPassword=employeeInfoBean.getPassword().trim();
				if(newPassword!=null && !newPassword.isEmpty()) {
					existingEmployeeInfoBean.setPassword(newPassword);
				}
				transaction.commit();
				isUpdated=true;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		entityManager.close();
		return isUpdated;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from EmployeeInfoBean";
		Query query=entityManager.createQuery(jpql);
		List<EmployeeInfoBean> employeeList=query.getResultList();
		entityManager.close();
		return employeeList;
	}

}
