package com.assetmanagement.excpection;

public class ValidationExpection extends Exception{


	private static final long serialVersionUID = -6031761730065128874L;
	
	public ValidationExpection(String errorMessage) {
		super(errorMessage);
	}

	public ValidationExpection(String errorMessage, Throwable t) {
		super(errorMessage, t);
	}

}
