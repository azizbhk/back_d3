package com.aziz.voyages.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.voyages.entities.voyage;
import com.aziz.voyages.service.voyageService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VoyageRESTController {
	
	@Autowired
	voyageService VoyageService;

	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<voyage> getAllvoyages() {
		return VoyageService.getAllvoyages();
	}
	

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public voyage getvoyageById(@PathVariable("id") Long id) {
		return VoyageService.getvoyage(id);
	}

	@RequestMapping(path="/addvoyage", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public voyage createvoyage(@RequestBody voyage voyage) {
		return VoyageService.savevoyage(voyage);
	}

	@RequestMapping(path="/updatevoyage", method = RequestMethod.PUT)
	public voyage updatevoyage(@RequestBody voyage voyage) {
		return VoyageService.updatevoyage(voyage);
	}

	@RequestMapping(value = "/deletevoyage/{id}", method = RequestMethod.DELETE)
	public void deletevoyage(@PathVariable("id") Long id) {
		VoyageService.deletevoyageById(id);
	}

	@RequestMapping(value = "/voyageCat/{idCat}", method = RequestMethod.GET)
	public List<voyage> getvoyagesByCatId(@PathVariable("idCat") Long idCat) {
		return VoyageService.findByCategorieIdCat(idCat);
	}

	@RequestMapping(value = "/voyagesByName/{nom}", method = RequestMethod.GET)
	public List<voyage> findByNomvoyageContains(@PathVariable("nom") String nom) {
		return VoyageService.findByNomvoyageContains(nom);
	}
}
