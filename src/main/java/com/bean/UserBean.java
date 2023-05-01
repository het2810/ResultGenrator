package com.bean;

import org.springframework.stereotype.Component;

@Component
public class UserBean {
	String firstName;
	String email;
	String password;
	Integer enrollmentNumber;
	String subjectRoleId;
	int role ;

	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getSubjectRoleId() {
		return subjectRoleId;
	}
	public void setSubjectRoleId(String subjectRoleId) {
		this.subjectRoleId = subjectRoleId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public Integer getEnrollmentNumber() {
		return enrollmentNumber;
	}
	public void setEnrollmentNumber(Integer enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}
	
}
