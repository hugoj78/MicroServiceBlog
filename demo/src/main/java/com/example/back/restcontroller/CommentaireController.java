package com.example.back.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.model.Commentaire;
import com.example.back.repository.CommentaireRepository;

@RestController
public class CommentaireController {
	
	@Autowired
	private CommentaireRepository commentaireRepository;

	@GetMapping(value = "/commentaires")
	public List<Commentaire> getComments() { 
		List<Commentaire> comments = new ArrayList<Commentaire>(); 
		commentaireRepository.findAll().forEach(comments::add);
		return comments;
	}
	
	@GetMapping(value = "/commentaire/{id}")
	public Optional<Commentaire> getComment(@PathVariable Long id) {
		return commentaireRepository.findById(id);
	}
	
	@PostMapping(value ="/commentaire/add")
	public void addComment(@RequestBody Commentaire u) {
		commentaireRepository.save(u);
	}
	
	@DeleteMapping(value = "/commentaire/delete/{id}")
	public void deleteComment(@PathVariable Long id) {
		commentaireRepository.deleteById(id);
	}
	
}
