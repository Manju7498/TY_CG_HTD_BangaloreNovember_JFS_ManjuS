package com.cg.forestmanagementspringrest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "haulier")
public class HaulierBean {
	@Id
	@Column
	private int haulierId;
	@Column
	private String haulierName;
	@Column
	private String StreetAddress1;
	@Column
	private String streetAddress2;
	@Column
	private String town;
	@Column
	private int pincode;
	@Column
	private long phoneNumber;
	@Column
	private String email;

	public int getHaulierId() {
		return haulierId;
	}

	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}

	public String getHaulierName() {
		return haulierName;
	}

	public void setHaulierName(String haulierName) {
		this.haulierName = haulierName;
	}

	public String getStreetAddress1() {
		return StreetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		StreetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
