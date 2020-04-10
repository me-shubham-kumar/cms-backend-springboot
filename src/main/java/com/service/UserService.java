package com.service;

import com.bean.User;

public interface UserService {
	
	public User store(User user);
	
	public User getUser(int userId);
	
	public void deleteProfile(int userId);
	
	public User updatePassword(int userId, String password);
	
	public User login(int userId, String password);
	
	

}
