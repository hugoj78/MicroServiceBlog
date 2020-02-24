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

import com.example.back.model.Categorie;
import com.example.back.repository.CategorieRepository;

@RestController
public class CategorieController {

	@Autowired
	private CategorieRepository categorieRepository;

	@GetMapping(value = "/categorie")
	public List<Categorie> getCategories() { 
		List<Categorie> categories = new ArrayList<Categorie>(); 
		categorieRepository.findAll().forEach(categories::add);
		return categories;
	}
	
	@GetMapping(value = "/categorie/{id}")
	public Optional<Categorie> getCategorie(@PathVariable Long id) {
		return categorieRepository.findById(id);
	}
	
	@PostMapping(value ="/categorie/add")
	public void addCategorie(@RequestBody Categorie u) {
		categorieRepository.save(u);
	}
	
	@DeleteMapping(value = "/categorie/delete/{id}")
	public void deleteCategorie(@PathVariable Long id) {
		categorieRepository.deleteById(id);
	}
}
