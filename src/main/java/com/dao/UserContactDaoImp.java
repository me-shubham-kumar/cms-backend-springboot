package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Contact;
import com.bean.User;


@Repository
public class UserContactDaoImp implements UserContactDao{
	
	@Autowired
	EntityManagerFactory emf;

	
	public int insertNewUser(User user) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			manager.persist(user);
		transaction.commit();
		return user.getUserId();
	}
	
	public User getUserById(int userId) {
		EntityManager manager = emf.createEntityManager();
		User user = (User)manager.find(User.class, userId);
		return user;
	}

	
	public User checkUser(int userId,String password) {
		try {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("select user from User user where user.userId=?1 and user.password=?2");
		query.setParameter(1, userId);
		query.setParameter(2, password);
		
		User user = (User)query.getSingleResult();
		return user;
		}catch(Exception e) {
			return null;
		}
		
		
	}
	
	
	public void deleteUser(int userId) {
		EntityManager manager = emf.createEntityManager();
		User user =(User)manager.find(User.class, userId);
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();	
			manager.remove(user);
			Query query = manager.createQuery("delete from Contact contact where contact.userIdReference=?1");
			query.setParameter(1, userId);
			query.executeUpdate();
		transaction.commit();
	}
	
	
	public User updateUserPassword(int userId, String password) {
		EntityManager manager = emf.createEntityManager();
		User user =(User)manager.find(User.class, userId);
		user.setPassword(password);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();	
			manager.merge(user);
		transaction.commit();
		return user;
	}
	
	
	public Contact addUserContact(Contact contact) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			manager.persist(contact);
		transaction.commit();
		return contact;
	}

	
	public List<Contact> searchUserContactByName(int userId, String name) {
		EntityManager manager = emf.createEntityManager();
		System.out.println("In DAO userId - "+userId+" name - "+name);
		
		Query query = manager.createQuery("select contact from Contact contact where contact.contactName LIKE '%'||:name||'%' and contact.userIdReference=:userId");
		query.setParameter("name", name);
		query.setParameter("userId", userId);
		List<Contact> contacts = query.getResultList();
		return contacts;
	}
	
	
	public void deleteUserContact(int contactId) {
		EntityManager manager = emf.createEntityManager();
		Contact contact =(Contact)manager.find(Contact.class, contactId);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();	
			manager.remove(contact);
		transaction.commit();
	}
	
	
	public List<Contact> getUserAllContacts(int userId) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("select contact from Contact contact where contact.userIdReference=?1");
		query.setParameter(1, userId);
		List<Contact> contacts = query.getResultList();
		return contacts;
	}
}
