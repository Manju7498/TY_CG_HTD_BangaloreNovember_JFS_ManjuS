package com.capgemini.loanprocessingsystem.dto;

import java.util.List;

public class LoanDetailsResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<LoanDetails> loanbean;

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

	public List<LoanDetails> getLoanbean() {
		return loanbean;
	}

	public void setLoanbean(List<LoanDetails> loanbean) {
		this.loanbean = loanbean;
	}
}// end of class
