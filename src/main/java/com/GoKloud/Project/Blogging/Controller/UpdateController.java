package com.GoKloud.Project.Blogging.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.Model.Blog;
import com.GoKloud.Project.Blogging.Repository.BlogRepository;
import com.GoKloud.Project.Blogging.Service.BlogService;


@RestController
@RequestMapping("/blogs")
public class UpdateController {
	
	@Autowired
	BlogRepository blogrep;
	
	@Autowired
	BlogService blgservice;
	
	
	@PostMapping("/update/{id}")
	public Blog updateBalog(@RequestBody Blog blogobj , @PathVariable("id") int blog_id) {
		return blgservice.updateBlog(blogobj, blog_id);
	}
}
