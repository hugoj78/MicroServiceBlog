package com.example.client.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.client.model.Article;
import com.example.client.model.Commentaire;
import com.example.client.model.User;


@FeignClient(name="ms-gateway")
@RibbonClient(name="back")
public interface MSUserProxy {
	@GetMapping(value = "/back/users")
	List<User> getUsers();
	
	@GetMapping(value = "/user/{id}")
	Optional<User> getUser(@PathVariable("id") Long id);
	
	@PostMapping(value = "/add")
	 List<User> addUser();
	
	@GetMapping(value = "/back/commentaires")
	List<Commentaire> GetComments();

	@GetMapping(value = "/commentaire/{id}")
	Optional<Commentaire> getComment(@PathVariable("id") Long id);
	
	@PostMapping(value = "/addComment")
	List<Commentaire> addComment();
	
	
	@GetMapping(value = "/back/articles")
	List<Article> getArticles();

	@GetMapping(value = "/article/{id}")
	Optional<Article> getArticle(@PathVariable("id") Long id);
	
	@PostMapping(value = "/addArticle")
	List<Article> addArticle(@RequestBody Article u);
	
}
