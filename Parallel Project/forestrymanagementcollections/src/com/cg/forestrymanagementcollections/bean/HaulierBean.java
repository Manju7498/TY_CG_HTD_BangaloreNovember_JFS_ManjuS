package com.cg.forestrymanagementcollections.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HaulierBean implements Serializable {
	private int haulierId;
	private String haulierName;
	private String StreetAddress1;
	private String streetAddress2;
	private String town;
	private int postcode;
	private long phoneNumber;
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

	

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
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
