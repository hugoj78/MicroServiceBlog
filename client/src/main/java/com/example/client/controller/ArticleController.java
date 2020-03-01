package com.example.client.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.client.model.Article;
import com.example.client.model.Commentaire;
import com.example.client.proxies.MSUserProxy;

public class ArticleController {
	@Autowired
	private MSUserProxy articleProxy;
	private MSUserProxy commentProxy;
	
	@RequestMapping("/articles")
	public String article(Model model) {
		List<Article> articles = articleProxy.getArticles();
		model.addAttribute("articles", articles);
		
		return "articles";			
	}
	@RequestMapping("/article/{idArticle}")
    public String getArticleByid(@PathVariable Long idArticle, Model model){
        Optional<Article> article =  articleProxy.getArticle(idArticle);
        Optional<Commentaire> commentaires = commentProxy.getComment(idArticle);

        model.addAttribute("articles", article);
        model.addAttribute("commentaires", commentaires);

        return "Article";
    }
	@RequestMapping(value ="/back/articles", method = RequestMethod.GET)
    public String formulaireArticle(Model model) {
        Article form = new Article();
        model.addAttribute("article", form);

        return "FormArticle";
    }

	   @RequestMapping(value="/articles/add", method = RequestMethod.POST)
	    public String addArticle(@ModelAttribute("article") @Validated Article c, Model model) {
	        System.out.println(c);
	        List<Article> articles = articleProxy.addArticle(c);
	       

	        model.addAttribute("articles", articles);

	        return "Articles";
	    }
	   
}