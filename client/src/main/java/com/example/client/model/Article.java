package com.example.client.model;

public class Article {
	private Long id;
	private Long id_categorie;
	private Long id_user;
	private String date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(Long id_categorie) {
		this.id_categorie = id_categorie;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
