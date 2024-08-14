package com.oracle.project.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String userPassword;
	private boolean active;
	private String roles; //Roles are authorities, ROLE_USER,ROLE_ADMIN
	
	/*
	 * Example:
	 * 1 Yug 123 true ROLE_USER
	 * 2 Priya 124 true ROLE_ADMIN
	 * 3 Batool 125 true ROLE_USER,ROLE_ADMIN
	 */
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", active="
				+ active + ", roles=" + roles + "]";
	}
	
	
}
