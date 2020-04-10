package com.dao;

import java.util.List;

import com.bean.Contact;
import com.bean.User;

public interface UserContactDao {
	public int insertNewUser(User user);
	public User checkUser(int userId, String password);
	public void deleteUser(int userId);
	public User updateUserPassword(int userId,String password);
	public User getUserById(int userId);

	public Contact addUserContact(Contact contact);
	public List<Contact> searchUserContactByName(int userId, String name);
	public void deleteUserContact(int contactId);
	public List<Contact> getUserAllContacts(int userId);

	

}
