package com.GoKloud.Project.Blogging.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GoKloud.Project.Blogging.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	
	public Optional<User> findByUserName(String username);
}
