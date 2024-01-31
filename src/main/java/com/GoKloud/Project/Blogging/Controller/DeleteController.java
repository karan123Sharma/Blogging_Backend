package com.GoKloud.Project.Blogging.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.Repository.BlogRepository;
import com.GoKloud.Project.Blogging.Service.BlogService;



@RestController
@RequestMapping("/blogs")
public class DeleteController {
	
	
	@Autowired
	BlogRepository blogrep;
	
	@Autowired 
	BlogService blgservice;
	
	
	@PostMapping("/delete/{id}")
	public String deleteBlogById(@PathVariable("id") int blog_id) {
		return blgservice.deleteBlog(blog_id);
	}	
}
