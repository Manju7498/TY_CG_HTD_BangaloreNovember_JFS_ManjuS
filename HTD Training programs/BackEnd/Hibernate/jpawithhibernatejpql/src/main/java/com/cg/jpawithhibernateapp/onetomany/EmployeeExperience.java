package com.cg.jpawithhibernateapp.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.jpawithhibernateapp.onetoone.EmployeeInfo;

@Entity
@Table(name="Employee_Experience")
public class EmployeeExperience {
	@Id
	@Column
	private int expid;
	@Column
	private String company;
	@Column
	private int noofyears;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeeInfo employeeInfo;
	public int getExpid() {
		return expid;
	}
	public void setExpid(int expid) {
		this.expid = expid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getNoofyears() {
		return noofyears;
	}
	public void setNoofyears(int noofyears) {
		this.noofyears = noofyears;
	}
	public EmployeeInfo getEmp() {
		return employeeInfo;
	}
	public void setEmp(EmployeeInfo emp) {
		this.employeeInfo = emp;
	}
	

}
