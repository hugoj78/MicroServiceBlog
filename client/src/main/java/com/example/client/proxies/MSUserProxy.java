package com.example.client.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.client.model.User;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-gateway")
@RibbonClient(name="demo")
public interface MSUserProxy {

	@GetMapping(value = "/demo/users")
	List<User> getUsers();
	
	@GetMapping(value = "/demo/user/{id}")
	Optional<User> getUser(@PathVariable("id") Long id);
	
	@PostMapping(value = "/demo/add")
	public List<User> addUser(@RequestBody User u);
}
