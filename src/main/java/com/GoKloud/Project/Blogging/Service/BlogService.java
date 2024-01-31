package com.GoKloud.Project.Blogging.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GoKloud.Project.Blogging.Repository.BlogRepository;


@Service
public class BlogService {
	
	@Autowired
	BlogRepository clgrepo;
	
	
	// Here Services will be included 
}
