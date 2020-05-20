package com.skateTitan.services.implementation;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skateTitan.dao.ProduitDao;
import com.skateTitan.exception.ProduitException;
import com.skateTitan.modeles.Produits;
import com.skateTitan.services.ProduitService;

@Service
public class ProduitServicesImpl implements ProduitService {
	
	@Autowired
	private ProduitDao produitDao;
	
	@Override
	public List<Produits> listeProduits() {
		return produitDao.findAll();
	}

	@Override
	public Produits afficherUnProduit(Integer id) {
		return produitDao.findById(id)
	            .orElseThrow(() -> new ProduitException("Produit", "id", id));
	}
	
	@Override
	public Produits creerUnProduit(Produits produit){
		return produitDao.save(produit);
	}
}
