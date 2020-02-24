package com.example.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.model.Commentaire;;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long>{
	
}
