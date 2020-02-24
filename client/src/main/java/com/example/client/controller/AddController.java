package com.example.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.client.model.User;
import com.example.client.proxies.MSUserProxy;

@Controller
public class AddController {

	@Autowired
	private MSUserProxy userProxy;
	
	@PostMapping("/add")
	public String add(@RequestBody User u, @ModelAttribute Model model) {
		
		List<User> users = userProxy.addUser(u);
		
		model.addAttribute("users", users);
		
		return "Home";
	}
}
