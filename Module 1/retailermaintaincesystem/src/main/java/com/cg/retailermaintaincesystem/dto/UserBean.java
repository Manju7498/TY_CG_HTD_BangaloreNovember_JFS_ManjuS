package com.cg.retailermaintaincesystem.dto;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UsersInfo")
public class UserBean {
	@Id
	@Column
	@GeneratedValue
	private int Id;
	@Column
	private String name;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userBean")
	private List<ProductBean> productBeans;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userBean")
	private List<OrderBean> orderBeans;
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
