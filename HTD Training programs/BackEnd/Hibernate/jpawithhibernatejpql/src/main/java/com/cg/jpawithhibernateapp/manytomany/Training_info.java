package com.cg.jpawithhibernateapp.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cg.jpawithhibernateapp.onetoone.EmployeeInfo;

@Entity
@Table(name="TRAINING_INFO")
public class Training_info {
	@Id
	@Column
	private int tid;
	@Column
	private String tname;
	@Column
	private int duration;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="training_employee",joinColumns=@JoinColumn(name="tid"),
	inverseJoinColumns = @JoinColumn(name="eid"))
	private List<EmployeeInfo> listemployeeinfo;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public List<EmployeeInfo> getListemployeeinfo() {
		return listemployeeinfo;
	}
	public void setListemployeeinfo(List<EmployeeInfo> listemployeeinfo) {
		this.listemployeeinfo = listemployeeinfo;
	}
	
	

}
