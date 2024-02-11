package com.GoKloud.Project.Blogging.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GoKloud.Project.Blogging.Model.Blog;
import com.GoKloud.Project.Blogging.Model.BlogCreationData;
import com.GoKloud.Project.Blogging.Model.BlogUpdateData;
import com.GoKloud.Project.Blogging.Model.User;
import com.GoKloud.Project.Blogging.Repository.BlogRepository;
import com.GoKloud.Project.Blogging.Repository.UserRepository;
import com.GoKloud.Project.Blogging.Service.BlogService;


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

