package com.example.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.client.model.User;
import com.example.client.proxies.MSUserProxy;

@Controller
public class HomeController {

	@Autowired
	private MSUserProxy userProxy;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		List<User> users = userProxy.getUsers();
		
		model.addAttribute("users", users);
		
		return "Home";
	}
	
	@RequestMapping("/addUser")
	public String add() {
		return "Add";	
	}
}
