package com.capgemini.loanprocessingsystem.dto;

import java.util.List;

public class LoanStatusResponse {

	private int statusCode;
	private String message;
	private String desription;
	private List<LoanStatus> loanbean;

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

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public List<LoanStatus> getLoanbean() {
		return loanbean;
	}

	public void setLoanbean(List<LoanStatus> loanbean) {
		this.loanbean = loanbean;
	}

}// end of class
