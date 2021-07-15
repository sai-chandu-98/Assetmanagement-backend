package com.assetmanagement.excpection;

public class EmployeAlreadyExistedException extends Exception {

	private static final long serialVersionUID = -6031761730065128874L;
	
	public EmployeAlreadyExistedException(String errorMessage) {
		super(errorMessage);
	}
	
	public EmployeAlreadyExistedException(String errorMessage, Throwable t) {
		super(errorMessage, t);
	}
}
