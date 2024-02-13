package com.GoKloud.Project.Blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.GoKloud.Project.Blogging.model.Blog;
import com.GoKloud.Project.Blogging.model.BlogCreationData;
import com.GoKloud.Project.Blogging.model.User;
import com.GoKloud.Project.Blogging.repository.BlogRepository;
import com.GoKloud.Project.Blogging.repository.UserRepository;



@RestController
@RequestMapping("/blogs")
@CrossOrigin("http://localhost:4200")
public class CreateController {
	
	@Autowired
	UserRepository userrep;
	
	@Autowired
	BlogRepository blogrep;
	
	@PostMapping("/insertData")
	public User insertData(@RequestBody User userobj){
		System.out.print("Gello");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	
		String Encpass = passwordEncoder.encode(userobj.getPassword());
		System.out.println((Encpass));
		userobj.setPassword(Encpass);
		return (userrep.save(userobj));
	}
	
//	@PostMapping("/createblog")
//	public Blog insertBlog(@RequestBody Blog blogobj ,  Long authorId) {
//		
//		System.out.println(authorId);
//	    User author = userrep.findById(authorId).orElseThrow(() -> new RuntimeException("User not found"));
//	    blogobj.setAuthor(author);
//		return (blogrep.save(blogobj));
//	}
	
	@PostMapping("/createblog")
	public Blog insertBlog(@RequestBody BlogCreationData requestData) {		
	    System.out.println(requestData.getAuthorId()); // Print author ID for debugging
	    User author = userrep.findById(requestData.getAuthorId())
	                         .orElseThrow(() -> new RuntimeException("User not found"));
	    Blog blog = requestData.getBlog();
	    blog.setAuthor(author);
	    return blogrep.save(blog);
	}

	
}
