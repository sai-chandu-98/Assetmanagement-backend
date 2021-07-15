package com.assetmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message =  "FirstName Can't be Empty")
	private String firstName;
	
	@NotBlank(message =  "LastName Can't be Empty")
	private String lastName;

	@NotBlank(message="email cant be empty")
	@Email(message =  "Invalid Email")
	private String email;

	@NotBlank(message =  "Password Can't be Empty")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFristName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("EmployeeDTO [firstName=%s, lastName=%s, email=%s, password=%s]", firstName,
				lastName, email, password);
	}

}
