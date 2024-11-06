package com.aziz.voyages.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.entities.voyage;
@RepositoryRestResource(path = "rest")
public interface voyageRepository extends JpaRepository<voyage, Long> {

	List<voyage> findByNomvoyage(String nom);

	List<voyage> findByNomvoyageContains(String nom);

	
	@Query("select p from voyage p where p.nomvoyage like %:nom and p.prixvoyage > :prix")
	List<voyage> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

	List<voyage> findByCategorie(Categorie categorie);

	List<voyage> findByCategorieIdCat(Long id);

	List<voyage> findByOrderByNomvoyageAsc();

	@Query("select v from voyage v order by v.nomvoyage ASC, v.prixvoyage ASC")
	List<voyage> triervoyagesNomsPrix();
	

}
