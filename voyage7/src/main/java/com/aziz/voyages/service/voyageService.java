package com.aziz.voyages.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.entities.voyage;

public interface voyageService {
	voyage savevoyage(voyage v);

	voyage updatevoyage(voyage v);

	void deletevoyage(voyage v);

	void deletevoyageById(Long id);

	voyage getvoyage(Long id);

	List<voyage> getAllvoyages();

	Page<voyage> getAllvoyagesParPage(int page, int size);

	List<voyage> findByNomvoyage(String nom);

	List<voyage> findByNomvoyageContains(String nom);

	List<voyage> findByNomPrix(String nom, Double prix);

	List<voyage> findByCategorie(Categorie categorie);

	List<voyage> findByCategorieIdCat(Long id);

	List<voyage> findByOrderByNomvoyageAsc();

	List<voyage> triervoyagesNomsPrix();
	List<Categorie> getAllCategories();


}
