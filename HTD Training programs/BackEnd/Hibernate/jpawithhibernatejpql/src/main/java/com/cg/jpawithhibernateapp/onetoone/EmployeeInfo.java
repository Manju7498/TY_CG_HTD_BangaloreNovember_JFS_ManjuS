package com.cg.jpawithhibernateapp.onetoone;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.jpawithhibernateapp.manytomany.Training_info;
import com.cg.jpawithhibernateapp.onetomany.EmployeeExperience;

@Entity
@Table(name="EMPLOYEE_INFO")
public class EmployeeInfo {
	@Id
	@Column(name="EMP_ID")
	private int empid;
	@Column(name="EMP_NAME")
	private String empname;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "empInfo")
	private EmployeeOtherInfo employeeOtherInfo;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employeeInfo")
	private EmployeeExperience employeeExperience;
	private List<Training_info> 
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
