package com.assetmanagement.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="requestasset")
public class RequestAssets implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  @Id
	  @GenericGenerator(name = "request_auto", strategy = "increment")
	  @GeneratedValue(generator ="request_auto")
	 
	
	@Column(name="id")
	private long id;
	
	@Column(name="request_date")
	private String requestDate;
	
	@Column(name="approve_date")
	private String approveDate;
	
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="comment")
	private String comment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "asset_id")
	private Assets assets;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "RequestAssets [id=" + id + ", requestDate=" + requestDate + ", approveDate=" + approveDate + ", status="
				+ status + ", comment=" + comment + ", employee=" + employee + ", assets=" + assets + "]";
	}

	

	

	
}
