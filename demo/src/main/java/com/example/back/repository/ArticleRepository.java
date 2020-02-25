package com.example.back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.model.Article;


@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{
	
	public List<Article> findByidcategorie(Long id_categorie);
}
