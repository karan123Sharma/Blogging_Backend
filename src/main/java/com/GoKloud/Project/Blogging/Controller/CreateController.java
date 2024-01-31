package com.GoKloud.Project.Blogging.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.Model.Blog;
import com.GoKloud.Project.Blogging.Model.User;
import com.GoKloud.Project.Blogging.Repository.BlogRepository;
import com.GoKloud.Project.Blogging.Repository.UserRepository;



@RestController
@RequestMapping("/blogs")
public class CreateController {
	
	@Autowired
	UserRepository userrep;
	
	@Autowired
	BlogRepository blogrep;
	
	@PostMapping("/insertData")
	public User insertData(@RequestBody User userobj){
		return (userrep.save(userobj));
	}
	
	@PostMapping("/create")
	public Blog insertBlog(@RequestBody Blog blogobj) {
		return (blogrep.save(blogobj));
	}
}
