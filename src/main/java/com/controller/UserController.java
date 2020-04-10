package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.service.UserService;


//3) Store Profile API: /createProfile  done
//4) Authenticate API: /login/{userId}/{password} done
//5) Get Profile API: /userProfile/{userId} done
//6) Update Password API: /updateUser/{userId}/{password} done
//7) Delete Profile API: /deleteUser/{userId} done


@RestController
@CrossOrigin
//@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "createProfile",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public User createProfile(@RequestBody User user){
		User newUser = userService.store(user);
		return newUser;
	}
	
	@RequestMapping(value = "login",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public User login(@RequestBody User user){
		User newUser = userService.login(user.getUserId(), user.getPassword());
		return newUser;
	}
	
	
	@RequestMapping(value = "userProfile/{userId}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public User userProfile(@PathVariable("userId") int userId) {
		User user = userService.getUser(userId);
		return user;
	}
	
	
	@RequestMapping(value = "updateUser",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public User updateUser(@RequestBody User user) {
		User updatedUser = userService.updatePassword(user.getUserId(), user.getPassword());
		return updatedUser;
	}
	
	@RequestMapping(value = "deleteUser/{userId}",
			produces = MediaType.TEXT_PLAIN_VALUE,
			method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId) {
		userService.deleteProfile(userId);
		return "deleted";
	}
	
	
	
	
	

}
