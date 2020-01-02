package com.cg.empwebapp.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Employee_Info")
public class EmployeeBean {
	@Id
	@Column
	@GeneratedValue
	private int employeeId;
	@Column
	private String employeeName;
	@Column(unique = true,nullable = false)
	private String employeeEmail;
	@Column
	private String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bean")
	private List<EmployeeAddressBean> addressBeans;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<EmployeeAddressBean> getAddressBeans() {
		return addressBeans;
	}
	public void setAddressBeans(List<EmployeeAddressBean> addressBeans) {
		this.addressBeans = addressBeans;
	}
	
}
