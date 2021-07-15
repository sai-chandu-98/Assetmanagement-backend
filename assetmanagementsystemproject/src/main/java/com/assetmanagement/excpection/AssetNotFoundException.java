package com.assetmanagement.excpection;

public class AssetNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssetNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public AssetNotFoundException(String errorMessage, Throwable t) {
		super(errorMessage, t);
	}
}
