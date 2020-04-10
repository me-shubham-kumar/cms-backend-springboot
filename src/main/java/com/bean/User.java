package com.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;
	private String name;
	private String password;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "userIdReference",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Contact> listOfContact;

	public User() {
		super();
	}
	public User(String name, String password, Date dateOfBirth, String phoneNumber) {
		super();
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}
	
	public User(String name, String password, Date dateOfBirth, String phoneNumber,
			List<Contact> listOfContact) {
		super();
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.listOfContact = listOfContact;
	}

	public User(int userId, String name, String password, Date dateOfBirth, String phoneNumber,
			List<Contact> listOfContact) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.listOfContact = listOfContact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Contact> getListOfContact() {
		return listOfContact;
	}

	public void setListOfContact(List<Contact> listOfContact) {
		this.listOfContact = listOfContact;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", phoneNumber=" + phoneNumber + ", listOfContact=" + listOfContact + "]";
	}
}
