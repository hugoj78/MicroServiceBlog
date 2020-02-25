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

import com.example.back.model.Article;
import com.example.back.repository.ArticleRepository;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping(value = "/articles")
	public List<Article> getArticles() { 
		List<Article> articles = new ArrayList<Article>(); 
		articleRepository.findAll().forEach(articles::add);
		return articles;
	}
	
	@GetMapping(value = "/article/{id}")
	public Optional<Article> getArticle(@PathVariable Long id) {
		return articleRepository.findById(id);
	}
	
	@PostMapping(value ="/article/add")
	public void addArticle(@RequestBody Article u) {
		articleRepository.save(u);
	}
	
	@DeleteMapping(value = "/article/delete")
	public void deleteArticle(@PathVariable Long id) {
		articleRepository.deleteById(id);
	}
	
	@GetMapping(value="/articles/categorie/{id_categorie}")
	public List<Article> getArticleByid_categorie(@PathVariable Long id_categorie) {
		List<Article> articlesWithCategorie = new ArrayList<Article>(); 
		articleRepository.findByidcategorie(id_categorie).forEach(articlesWithCategorie::add);
		return articlesWithCategorie;
	}
}
