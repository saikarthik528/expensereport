package com.proj.er.rest.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.proj.er.model.UserDetails;

public class UserDetailsRestEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String telephoneNum;
	private Date createdOn;
	
	public UserDetailsRestEntity() {
	}
	
	public UserDetailsRestEntity(UserDetails user) {
		this.setUserId(user.getUserId());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setUserName(user.getUserName());
		this.setEmail(user.getEmail());
		this.setTelephoneNum(user.getTelephoneNum());
		this.setCreatedOn(user.getCreatedOn());
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	@JsonSerialize(using = DateSerializer.class)
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public UserDetails convertToRoot() {
		UserDetails user = new UserDetails();
		user.setUserName(this.getUserName());
		user.setFirstName(this.getFirstName());
		user.setLastName(this.getLastName());
		user.setPassword(this.getPassword());
		user.setEmail(this.getEmail());
		user.setTelephoneNum(this.getTelephoneNum());
		user.setUserId(this.getUserId());
		return user;
	}

}
