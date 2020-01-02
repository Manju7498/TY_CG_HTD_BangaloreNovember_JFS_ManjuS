package com.cg.springboot.bean;

import java.util.List;

public class EmployeeResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<EmployeeBean> bean;
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
	public List<EmployeeBean> getBean() {
		return bean;
	}
	public void setBean(List<EmployeeBean> bean) {
		this.bean = bean;
	}

}
