package com.example.back.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.model.User;
import com.example.back.repository.UserRepository;

@RestController
public class Controller {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/login") 
	public Optional<User> login(@RequestBody User u){
		return userRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		System.out.println("Trace getUser");
		List<User> users = new ArrayList<User>(); 
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	@GetMapping(value = "/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping(value ="/user/add")
	public void addUser(@RequestBody User u) {
		userRepository.save(u);
	}
	
	@DeleteMapping(value = "/user/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	

}
