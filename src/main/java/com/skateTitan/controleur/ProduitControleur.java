package com.skateTitan.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skateTitan.dao.ProduitDao;
import com.skateTitan.exception.ProduitException;
import com.skateTitan.modeles.Produits;
import com.skateTitan.services.ProduitService;


@RestController
public class ProduitControleur {
	
	@Autowired
	private ProduitDao produitDao;
	
	@Autowired
	private ProduitService produitService;
	
	// Afficher les produits
	@GetMapping(value="/produits")
	public List<Produits> listeProduits(){
			return produitService.listeProduits();
		}
		
	//Récupérer un produit par son Id
	@GetMapping(value="/produits/{id}")
	public Produits afficherUnProduit(@PathVariable(value = "id") Integer id) {
		return produitService.afficherUnProduit(id);
	}
	
	//creer un nouveau produit
	@PostMapping("/produits/ajouter")
	public Produits creerUnProduit(@RequestBody Produits produit) {
	    return produitService.creerUnProduit(produit);
	}
	
	// Modifier un produit
	@PutMapping("/produits/modifier/{id}")
	public Produits modifierProduit(@PathVariable(value = "id") Integer id, @RequestBody Produits produitDetails) {
		Produits produit = produitDao.findById(id)
	            .orElseThrow(() -> new ProduitException("Produit", "id", id));

		produit.setNom(produitDetails.getNom());
		produit.setPrix(produitDetails.getPrix());

	    Produits modifProduit = produitDao.save(produit);
	    return modifProduit;
	}
	
	// Delete a Note
	@DeleteMapping("/produits/supprimer/{id}")
	public ResponseEntity<?> suppressionProduit(@PathVariable(value = "id") Integer id) {
	    Produits produit = produitDao.findById(id)
	            .orElseThrow(() -> new ProduitException("Note", "id", id));

	    produitDao.delete(produit);

	    return ResponseEntity.ok().build();
	}

}
