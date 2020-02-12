package com.capgemini.loanprocessingsystem.dto;

public class LoanApplicationProcessingResponse {
	private int statusCode;
	private String message;
	private String description;
	private Login login;
	private Login addAccount;
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
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Login getAddAccount() {
		return addAccount;
	}
	public void setAddAccount(Login addAccount) {
		this.addAccount = addAccount;
	}

}