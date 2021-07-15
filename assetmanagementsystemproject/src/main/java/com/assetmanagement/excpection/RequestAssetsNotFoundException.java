package com.assetmanagement.excpection;

public class RequestAssetsNotFoundException extends Exception{

private static final long serialVersionUID = -6031761730065128874L;
	
	public RequestAssetsNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public RequestAssetsNotFoundException(String errorMessage, Throwable t) {
		super(errorMessage, t);
	}
}
