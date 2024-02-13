package com.GoKloud.Project.Blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.model.User;
import com.GoKloud.Project.Blogging.service.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
public class AuthController {
	
	
	@Autowired 
	UserService userser;
	@PostMapping("/authenticateuser")
	public String authenticateUser(@RequestBody User user) {
		return userser.authenticateUser(user);
	    		
	}
	
}
