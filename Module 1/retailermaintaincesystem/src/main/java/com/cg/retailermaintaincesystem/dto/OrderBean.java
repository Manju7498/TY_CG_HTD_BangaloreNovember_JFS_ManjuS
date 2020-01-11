package com.cg.retailermaintaincesystem.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderInfo")
public class OrderBean {
	@Id
	@Column
	private int Id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_Id",referencedColumnName="Id")
	private ProductBean productBean;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id",referencedColumnName="Id")
	private UserBean userBean;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
}
