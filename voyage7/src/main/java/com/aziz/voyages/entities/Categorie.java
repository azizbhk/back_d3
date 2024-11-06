package com.aziz.voyages.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	
	@OneToMany(mappedBy = "categorie")
	@JsonIgnore
	private List<voyage> voyages;

	public Categorie() {
	}

	public Categorie(String nomCat, String descriptionCat, List<voyage> voyages) {
		super();
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
		this.voyages = voyages;
	}

	public Long getIdCat() {
		return idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public String getDescriptionCat() {
		return descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	public List<voyage> getvoyages() {
		return voyages;
	}

	public void setvoyages(List<voyage> voyages) {
		this.voyages = voyages;
	}
}