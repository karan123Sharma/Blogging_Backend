package com.GoKloud.Project.Blogging.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.GoKloud.Project.Blogging.Model.User;
import com.GoKloud.Project.Blogging.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userepo;
	
	
	//user services here
	
	public String authenticateUser(User user) {
		Optional<User> opUser = userepo.findById(user.getId());
		if(opUser.isPresent()) {
			User dbuser = opUser.get();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(user.getPassword(), dbuser.getPassword())) {
				return "Authenticated User";
			}
			else {
				return "Incorrect Password"; 
			}	
		}
		return "not found";		
	}

}
