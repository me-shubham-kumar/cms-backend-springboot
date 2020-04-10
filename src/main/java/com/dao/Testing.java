package com.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bean.User;

@Repository
public class Testing {
	
	@Autowired
	EntityManagerFactory emf;
	
	public int saveUser() {
		
		Date date = Date.valueOf("2019-12-31");
		User user = new User("shubham kumar","12345",date,"9800439339");
		EntityManager manager = emf.createEntityManager();
		System.out.println("hello ");
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			manager.persist(user);
		transaction.commit();
		//manager.persist(new Contact("Arun","9800439339",user.getUserId()));
		
		return user.getUserId();
	}
	
	public int insertUser(User user) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
			manager.persist(user);
		transaction.commit();
		return user.getUserId();
	}
	
	

}
