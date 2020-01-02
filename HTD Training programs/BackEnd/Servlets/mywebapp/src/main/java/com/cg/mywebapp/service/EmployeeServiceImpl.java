package com.cg.mywebapp.service;

import java.util.List;

import com.cg.mywebapp.beans.EmployeeInfoBean;
import com.cg.mywebapp.dao.EmployeeDao;
import com.cg.mywebapp.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl  implements EmployeeService{
	private EmployeeDao dao=new EmployeeDaoImpl();
	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
		return dao.searchEmployee(empId);
	}
	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		return dao.authenticate(empId, password);
	}
	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}
	@Override
	public boolean deleteEmployee(int empId) {
		return dao.deleteEmployee(empId);
	}
	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employeeInfoBean);
	}
	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
