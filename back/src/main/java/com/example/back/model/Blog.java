package com.example.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "categorie")
	private String categorie;
	@Column(name = "auteur")
	private String auteur;
	@Column(name = "date")
	private String date;
	@Column(name = "contenu")
	private Long contenu;

}
