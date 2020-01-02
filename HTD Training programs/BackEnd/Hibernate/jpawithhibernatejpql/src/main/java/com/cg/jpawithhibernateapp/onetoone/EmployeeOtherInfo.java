package com.cg.jpawithhibernateapp.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEEOTHER_INFO")
public class EmployeeOtherInfo {
	@Id
	@Column
	private int id;
	@Column
	private int pancard;
	@Column(name="fathername")
	private String fname;
	@Column(name="mothername")
	private String mname;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeeInfo empInfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPancard() {
		return pancard;
	}
	public void setPancard(int pancard) {
		this.pancard = pancard;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public EmployeeInfo getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(EmployeeInfo empInfo) {
		this.empInfo = empInfo;
	}

}
