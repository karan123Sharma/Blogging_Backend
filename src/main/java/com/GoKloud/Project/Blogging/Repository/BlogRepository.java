package com.GoKloud.Project.Blogging.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GoKloud.Project.Blogging.Model.Blog;

public interface BlogRepository extends JpaRepository<Blog,Integer>{

}
