package com.GoKloud.Project.Blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.repository.BlogRepository;
import com.GoKloud.Project.Blogging.service.BlogService;



@RestController
@RequestMapping("/blogs")
@CrossOrigin("http://localhost:4200")
public class DeleteController {
	
	
	@Autowired
	BlogRepository blogrep;
	
	@Autowired 
	BlogService blgservice;
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteBlogById(@PathVariable("id") Long blog_id) {
		return blgservice.deleteBlog(blog_id);
	}	
}
