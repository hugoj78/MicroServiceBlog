package com.example.client.model;

public class Commentaire {
	private Long id;
	private Long id_user;
	private Long id_article;
	private String texte;
	private String date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public Long getId_article() {
		return id_article;
	}
	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setId_user(User user) {
		// TODO Auto-generated method stub
		
	}
	public void setTexte(Article article) {
		// TODO Auto-generated method stub
		
	}
	
}
