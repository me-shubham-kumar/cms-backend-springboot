package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Contact;
import com.service.ContactService;

//1) Get Contact API: /user/contacts/{userId} done
//2) Search Contact by Name API: /user/{userId}/{name} done
//8) Delete Contact API: /user/delete/{contactId} done
//9) Add Contact API: /user/addContact/{userId} done


@RestController
@CrossOrigin
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping(value = "user/contacts/{userId}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public List<Contact> getContact(@PathVariable("userId") int userId) {
		List<Contact> contacts = contactService.getMyContacts(userId);
		return contacts;
	}
	
	
	@RequestMapping(value = "user/{userId}/{name}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public List<Contact> getContactByName(@PathVariable("userId") int userId,@PathVariable("name") String name) {
		System.out.println("userId - "+userId+" name - "+name);
		List<Contact> contacts = contactService.searchContactByName(userId, name);
		return contacts;
	}
	
	@RequestMapping(value = "user/delete/{contactId}",
			produces = MediaType.TEXT_PLAIN_VALUE,
			method = RequestMethod.GET)
	public String deleteContact(@PathVariable("contactId") int contactId) {
		contactService.deleteContact(contactId);
		return "deleted";
	}
	
	@RequestMapping(value = "user/addContact/{userId}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public String addContact(@PathVariable("userId") int userId,@RequestBody Contact contact){
		contact.setUserIdReference(userId);
		Contact insertedContact = contactService.addContact(contact);
		if(insertedContact!=null) {
			return "added";
		}else {
			return "failure";
		}
	}

}
