package com.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	/* @GeneratedValue(strategy = GenerationType.AUTO) */ 
	@Column(name = "contactId")
	private int contactId;
	@Column(name = "contactName")
	private String contactName;
	@Column(name = "contactNumber")
	private String contactNumber;
	@Column(name = "userIdReference")
	private int userIdReference;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int contactId, String contactName, String contactNumber, int userIdReference) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.userIdReference = userIdReference;
	}
	public Contact(String contactName, String contactNumber, int userIdReference) {
		super();
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.userIdReference = userIdReference;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getUserIdReference() {
		return userIdReference;
	}
	public void setUserIdReference(int userIdReference) {
		this.userIdReference = userIdReference;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", userIdReference=" + userIdReference + "]";
	}
}
