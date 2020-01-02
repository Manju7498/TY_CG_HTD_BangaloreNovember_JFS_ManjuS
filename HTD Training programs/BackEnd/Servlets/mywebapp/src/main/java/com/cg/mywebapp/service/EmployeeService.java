package com.cg.mywebapp.service;

import java.util.List;

import com.cg.mywebapp.beans.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean searchEmployee(int empId);
	public EmployeeInfoBean authenticate(int empId,String password);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
    public boolean deleteEmployee(int empId);
    public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
    public List<EmployeeInfoBean> getAllEmployees();
}//end of interface
