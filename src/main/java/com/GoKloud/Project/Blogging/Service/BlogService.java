package com.GoKloud.Project.Blogging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.GoKloud.Project.Blogging.model.Blog;
import com.GoKloud.Project.Blogging.repository.BlogRepository;


@Service
public class BlogService {
	
	@Autowired
	BlogRepository blogrep;
	
	// Here Services will be included 
	
	
	public Blog getBlogsById(Long blog_id) {
		Blog temp = null;
		Optional<Blog> bobj = blogrep.findById(blog_id);
		if(bobj != null) {
			temp = bobj.get();
			return temp;
		}
		return temp;
	}
	
	public List<Blog> getAllBlogs(){
		List<Blog>allBlogs = blogrep.findAll();
		return allBlogs;
	}
	
	
	public Blog updateBlog(Blog blogobj ,Long blog_id) {
		Optional<Blog> mobj = blogrep.findById(blog_id);
		if(mobj != null) {	
			blogobj.setBlogId((long)blog_id);
			return(blogrep.save(blogobj));
		}
		return null;
	}

	public String deleteBlog(Long blog_id) {
		blogrep.deleteById(blog_id);
		return "Done";
	}	
	
}
