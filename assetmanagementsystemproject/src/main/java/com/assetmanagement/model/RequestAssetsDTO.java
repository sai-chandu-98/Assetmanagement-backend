package com.assetmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class RequestAssetsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message="requestdate can't be empty")
	private String requestDate;
	
	@NotBlank(message="approvedate can't be empty")
	private String approveDate;
	
	
	@NotBlank(message="status can't be empty")
	private String status;
	
	
	@NotBlank(message="comment can't be empty")
	private String comment;
	
	@Positive(message="employeeid can't be zero")
	private long employeeId;
	
	@Positive(message="assetid can't be zero")
	private long assetId;



	public String getRequestDate() {
		return requestDate;
	}



	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}



	public String getApproveDate() {
		return approveDate;
	}



	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}
	


	@Override
	public String toString() {
		return String.format("RequestAssetsDTO[requestDate = %s ,approveDate = %s, status=%s,comment=%S]",requestDate,approveDate,
				status,comment); 
	}



	public long getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}



	public long getAssetId() {
		return assetId;
	}



	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}


	

}
