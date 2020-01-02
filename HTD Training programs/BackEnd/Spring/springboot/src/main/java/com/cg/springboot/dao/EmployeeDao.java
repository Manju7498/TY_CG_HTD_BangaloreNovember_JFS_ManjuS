package com.cg.springboot.dao;

import java.util.List;

import com.cg.springboot.bean.EmployeeBean;


public interface EmployeeDao {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	//public EmployeeBean getEmployee(String email);
	public List<EmployeeBean> getEmployees(String key);
	public boolean changePassword(int employeeId,String password);
	public boolean deleteEmployee(int employeeId);
}
