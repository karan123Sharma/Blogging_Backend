package com.GoKloud.Project.Blogging.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class MainController {
	
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
	@PostMapping("/update/{id}")
	public Blog updateBalog(@RequestBody Blog blogobj , @PathVariable("id") int blog_id) {
		Optional<Blog> mobj = blogrep.findById(blog_id);
		if(mobj != null) {	
			blogobj.setBlogId((long)blog_id);
			return(blogrep.save(blogobj));
		}
		return null;
	}
	
	@PostMapping("/delete/{id}")
	public String updateBalog(@PathVariable("id") int blog_id) {
		blogrep.deleteById(blog_id);
		return "Done";
	}	
	
	@GetMapping("/{id}")
	public Blog getBlog(@PathVariable("id") int blog_id) {
		Blog temp = null;
		Optional<Blog> bobj = blogrep.findById(blog_id);
		if(bobj != null) {
			temp = bobj.get();
			return temp;
		}
		return temp;
	}
	@GetMapping("/")
	public List<Blog> getAllBlogs(){
		List<Blog>allBlogs = blogrep.findAll();
		return allBlogs;
	}
	
}
