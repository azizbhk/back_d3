package com.aziz.voyages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.entities.voyage;
import com.aziz.voyages.repos.CategorieRepository;
import com.aziz.voyages.repos.ImageRepository;
import com.aziz.voyages.repos.voyageRepository;
@Service

public class voyageServiceImpl implements voyageService  {
	@Autowired
	voyageRepository voyageRepository;
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	CategorieRepository categorieRepository;
	

	@Override
	public voyage savevoyage(voyage v) {
		return voyageRepository.save(v);
	}
	

	/*
	 * @Override public voyage updatevoyage(voyage v) {
	 * 
	 * return voyageRepository.save(v); }
	 */
	
	@Override
	public voyage updatevoyage(voyage v) {
//	Long oldProdImageId = this.getEquipe(p.getIdEquipe()).getImage().getIdImage();
	//Long newProdImageId = p.getImage().getIdImage();
	voyage prodUpdated = voyageRepository.save(v);
	//if (oldProdImageId != newProdImageId) //si l'image a été modifiée
//	imageRepository.deleteById(oldProdImageId);
	return prodUpdated;
	}

	@Override
	public void deletevoyage(voyage v) {
		 voyageRepository.delete(v);
		
		
	}

	@Override
	public void deletevoyageById(Long id) {
		 voyageRepository.deleteById(id);
		
		
	}

	@Override
	public voyage getvoyage(Long id) {
		 return voyageRepository.findById(id).get();
	}

	@Override
	public List<voyage> getAllvoyages() {
		
		return voyageRepository.findAll();
	}

	@Override
	public Page<voyage> getAllvoyagesParPage(int page, int size) {
		
		return voyageRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<voyage> findByNomvoyage(String nom) {
		
		return voyageRepository.findByNomvoyage(nom);
	}

	@Override
	public List<voyage> findByNomvoyageContains(String nom) {
		
		return voyageRepository.findByNomvoyageContains(nom);
	}

	@Override
	public List<voyage> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<voyage> findByCategorie(Categorie categorie) {
		
		return voyageRepository.findByCategorie(categorie);
	}

	@Override
	public List<voyage> findByCategorieIdCat(Long id) {

		return voyageRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<voyage> findByOrderByNomvoyageAsc() {
		
		return voyageRepository.findByOrderByNomvoyageAsc();
	}

	@Override
	public List<voyage> triervoyagesNomsPrix() {
		
		return voyageRepository.triervoyagesNomsPrix();
	}

	@Override
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

}
