package com.capgemini.loanprocessingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_details")
public class LoanDetails {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;
	@Column
	private String typeOfLoan;
	@Column(name = "loanDuration")
	private int loanDuration;
	@Column
	private double loanPOI;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public double getLoanPOI() {
		return loanPOI;
	}

	public void setLoanPOI(double loanPOI) {
		this.loanPOI = loanPOI;
	}

}// end of class
