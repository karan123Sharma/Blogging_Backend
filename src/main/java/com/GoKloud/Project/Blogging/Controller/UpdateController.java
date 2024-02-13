package com.GoKloud.Project.Blogging.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.model.Blog;
import com.GoKloud.Project.Blogging.model.BlogCreationData;
import com.GoKloud.Project.Blogging.model.BlogUpdateData;
import com.GoKloud.Project.Blogging.model.User;
import com.GoKloud.Project.Blogging.repository.BlogRepository;
import com.GoKloud.Project.Blogging.repository.UserRepository;
import com.GoKloud.Project.Blogging.service.BlogService;


@RestController
@RequestMapping("/blogs")
@CrossOrigin("http://localhost:4200")
public class UpdateController {
	
	@Autowired
	BlogRepository blogrep;
	
	@Autowired
	BlogService blgservice;
	
	@Autowired
	UserRepository userrep;
	
	
	@PostMapping("/update/{id}")
	public Blog updateBalog(@RequestBody BlogUpdateData requestData) {
		System.out.println("Hello This is Author id "+requestData.getAuthorId()); 
		System.out.println("Hello This is Blogid id "+requestData.getBlogId()); 
 
	    User author = userrep.findById(requestData.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));
	    
	    Blog blogobj = requestData.getBlog();
	    blogobj.setAuthor(author);		
		return blgservice.updateBlog(blogobj, requestData.getBlogId());
	}
}

