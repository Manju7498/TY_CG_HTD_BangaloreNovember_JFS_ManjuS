package com.cg.retailermaintaincesystem.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductInfo")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue
	private int Id;
	@Column
	private String name;
	@Column
	private int quantity;
	@Column
	private String details;
	@Column
	private double cost;
	@OneToOne(cascade = CascadeType.ALL)
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
