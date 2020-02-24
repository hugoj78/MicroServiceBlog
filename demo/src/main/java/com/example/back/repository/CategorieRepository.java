package com.example.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long>{

}
