package com.skateTitan.services;

import java.util.List;

import com.skateTitan.modeles.Produits;


public interface ProduitService  {

	public List<Produits> listeProduits();
	
	public Produits afficherUnProduit(Integer id);
	
	public Produits creerUnProduit(Produits produit);
	
}
