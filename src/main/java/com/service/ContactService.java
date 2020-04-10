package com.service;

import java.util.List;

import com.bean.Contact;

public interface ContactService {
	
	public Contact addContact(Contact contact);
	
	public List<Contact> searchContactByName(int userId, String name);
	
	public void deleteContact(int contactId);
	
	public List<Contact> getMyContacts(int userId);

}
