package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Testing;

@Service
public class TestingService {

	@Autowired
	Testing testing;
	
	public String performTesting() {
		if(testing.saveUser()>0) {
			return "Successful";
		}else {
			return "Something went wrong";
		}
	}
}
