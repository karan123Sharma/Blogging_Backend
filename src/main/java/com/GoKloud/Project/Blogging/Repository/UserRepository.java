package com.GoKloud.Project.Blogging.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GoKloud.Project.Blogging.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
