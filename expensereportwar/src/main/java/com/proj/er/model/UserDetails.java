package com.proj.er.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "\"USERDETAILS\"")
public class UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"USERID\"")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "\"FIRSTNAME\"")
	private String firstName;

	@Column(name = "\"LASTNAME\"")
	private String lastName;

	@Column(name = "\"USERNAME\"")
	private String userName;

	@Column(name = "\"PASSWORD\"")
	private String password;

	@Column(name = "\"EMAIL\"")
	private String email;

	@Column(name = "\"TELEPHONENUM\"")
	private String telephoneNum;

	@Column(name = "\"CREATEDON\"")
	private Date createdOn;

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", Firstname=" + firstName + ", Username=" + userName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	public void updateFields(UserDetails userDetails) {
		this.setFirstName(userDetails.getFirstName());
		this.setLastName(userDetails.getLastName());
		this.setEmail(userDetails.getEmail());
		this.setTelephoneNum(userDetails.getTelephoneNum());
	}

}