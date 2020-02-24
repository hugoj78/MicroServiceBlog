package com.example.back.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.model.Article;
import com.example.back.repository.ArticleRepository;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping(value = "/article")
	public List<Article> getCategories() { 
		List<Article> categories = new ArrayList<Article>(); 
		articleRepository.findAll().forEach(categories::add);
		return categories;
	}
	
	@GetMapping(value = "/article/{id}")
	public Optional<Article> getCategorie(@PathVariable Long id) {
		return articleRepository.findById(id);
	}
	
	@PostMapping(value ="/article/add")
	public void addCategorie(@RequestBody Article u) {
		articleRepository.save(u);
	}
	
	@DeleteMapping(value = "/article/delete")
	public void deleteCategorie(@PathVariable Long id) {
		articleRepository.deleteById(id);
	}
}
