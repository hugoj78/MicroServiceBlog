package com.example.back.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	public Optional<User> findByUsernameAndPassword(String username, String password);
}