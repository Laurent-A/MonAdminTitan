package com.skateTitan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skateTitan.modeles.Produits;

@Repository
public interface ProduitDao extends JpaRepository <Produits, Integer>{

}
