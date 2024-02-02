package com.GoKloud.Project.Blogging.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.Model.User;
import com.GoKloud.Project.Blogging.Service.UserService;


@RestController
public class AuthController {
	
	
	@Autowired 
	UserService userser;
	
	@PostMapping("/authenticateuser")
	public String auth(@RequestBody User user) {
		return userser.authenticateUser(user);
	}
	
}
