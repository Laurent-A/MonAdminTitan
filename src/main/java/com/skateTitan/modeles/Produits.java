package com.skateTitan.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "produit")
public class Produits {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@NotNull
    private String nom;
    private int prix;
    
	public Produits() {
		super();
	}
	
	public Produits(int id, String nom, int prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produits [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}
	

}
