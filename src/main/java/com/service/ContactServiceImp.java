package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Contact;
import com.dao.UserContactDao;

@Service
public class ContactServiceImp implements ContactService{
	
	@Autowired
	UserContactDao userContactDao;
	
	
	
	public Contact addContact(Contact contact) {
		Contact updatedContact = userContactDao.addUserContact(contact);
		return updatedContact;
	}
	
	public void deleteContact(int contactId) {
		userContactDao.deleteUserContact(contactId);
	}
	
	public List<Contact> getMyContacts(int userId) {
		List<Contact> contacts = userContactDao.getUserAllContacts(userId);
		return contacts;
	}
	
	public List<Contact> searchContactByName(int userId, String name) {
		List<Contact> contacts = userContactDao.searchUserContactByName(userId, name);
		return contacts;
	}
	
}
