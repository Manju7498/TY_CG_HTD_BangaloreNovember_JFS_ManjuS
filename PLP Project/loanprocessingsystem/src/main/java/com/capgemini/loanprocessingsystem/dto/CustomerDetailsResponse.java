package com.capgemini.loanprocessingsystem.dto;

import java.util.List;

public class CustomerDetailsResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<CustomerDetails> customerbean;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CustomerDetails> getBean() {
		return customerbean;
	}

	public void setBean(List<CustomerDetails> bean) {
		this.customerbean = bean;
	}
}
