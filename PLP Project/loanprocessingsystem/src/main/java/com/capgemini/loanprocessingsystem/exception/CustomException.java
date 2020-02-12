package com.capgemini.loanprocessingsystem.exception;

public class CustomException extends Exception {

	private String exceptionMsg;

	public CustomException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	public CustomException() {
		super();
	}

	@Override
	public String getMessage() {
		return exceptionMsg;
	}

	public void exceptionMessage() {
		System.err.println("\n" + exceptionMsg + "\n");
	}

}// end of class
