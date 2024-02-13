package com.GoKloud.Project.Blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.model.Blog;
import com.GoKloud.Project.Blogging.model.User;
import com.GoKloud.Project.Blogging.repository.BlogRepository;
import com.GoKloud.Project.Blogging.repository.UserRepository;
import com.GoKloud.Project.Blogging.service.BlogService;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("http://localhost:4200")
public class MainController {
	
	@Autowired
	UserRepository userrep;
	
	@Autowired
	BlogRepository blogrep;
	
	@Autowired
	BlogService blgservice;
	
		
	@GetMapping("/{id}")
	public Blog getBlog(@PathVariable("id") Long blog_id) {
		return blgservice.getBlogsById(blog_id);
	}	
	
	
	@GetMapping("/")
	public List<Blog> getAllBlogs(){
		return blgservice.getAllBlogs();
	}
	
	@GetMapping("/alluser")
	public List<User> getAllUser(){
		return userrep.findAll();
	}
	
	@GetMapping("/AllBlogsId/{id}")
    public List<Blog> getBlogsByAuthorId(@PathVariable("id") Long authorId) {
		System.out.println(blogrep.findByAuthorId(authorId));
        return blogrep.findByAuthorId(authorId);
    }
	
	
}
