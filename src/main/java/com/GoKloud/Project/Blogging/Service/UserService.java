package com.GoKloud.Project.Blogging.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.GoKloud.Project.Blogging.model.User;
import com.GoKloud.Project.Blogging.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userepo;
	
	
	//user services here
	
	public String authenticateUser(User user) {
		System.out.println("Hello");
		Optional<User> opUser = userepo.findByUserName(user.getUsername());
		System.out.println(opUser);
		
		if(opUser.isPresent()) {
			User dbuser = opUser.get();
			System.out.println(dbuser.getPassword());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(user.getPassword(), dbuser.getPassword())) {
				System.out.println("Password Matched");
				return "Authenticated User";
			}
			else {
				return "Incorrect Password";
			}	
		}
		return "Not Found";
		}

}
