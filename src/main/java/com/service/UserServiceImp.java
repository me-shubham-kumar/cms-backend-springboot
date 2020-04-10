package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.UserContactDao;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserContactDao userContactdao;
	
	
	public User store(User user) {
		user.setUserId(userContactdao.insertNewUser(user));
		return user;
	}

	
	public void deleteProfile(int userId) {
		userContactdao.deleteUser(userId);
	}

	
	public User updatePassword(int userId, String password) {
		User updatedUser = userContactdao.updateUserPassword(userId, password);
		return updatedUser;
	}

	
	public User login(int userId, String password) {
		User user = userContactdao.checkUser(userId,password);
		if(user!=null)
			return user;
		return null;
	}


	public User getUser(int userId) {
		User user = userContactdao.getUserById(userId);
		return user;
	}


}
