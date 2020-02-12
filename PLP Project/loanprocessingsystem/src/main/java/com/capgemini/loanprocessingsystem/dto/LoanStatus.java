package com.capgemini.loanprocessingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_status")
public class LoanStatus {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int approvalId;
	@Column
	private int custId;
	@Column
	private double interestRate;
	@Column
	private int loan_Id;
	@Column
	private String typeOfLoan;
	@Column(name = "approvalStatus", nullable = false)
	private String approvalStatus;

	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getLoan_Id() {
		return loan_Id;
	}

	public void setLoan_Id(int loan_Id) {
		this.loan_Id = loan_Id;
	}

	public String getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
}
