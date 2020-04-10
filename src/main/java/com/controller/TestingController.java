package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.dao.Testing;

@RestController
@CrossOrigin
public class TestingController {
	
	@Autowired
	Testing testing;
	
	@RequestMapping("testUrl")
	public int testUrl() {
		return testing.saveUser();
	}
	
	@RequestMapping(value = "insertUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String insertUser(@RequestBody User user) {
		int userId = testing.insertUser(user);
		return "Successfully " + userId;
	}

}
