package com.GoKloud.Project.Blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GoKloud.Project.Blogging.model.Blog;

public interface BlogRepository extends JpaRepository<Blog,Long>{
	
	List<Blog>findByAuthorId(Long authorId);

}
