package com.cg.empwebapp.service;

import java.util.List;

import com.cg.empwebapp.bean.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	//public EmployeeBean getEmployee(String email);
	public List<EmployeeBean> getEmployees(String key);
	public boolean changePassword(int employeeId,String password);
}
