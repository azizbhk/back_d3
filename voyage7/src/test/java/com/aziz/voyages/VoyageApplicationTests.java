package com.aziz.voyages;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.entities.voyage;
import com.aziz.voyages.repos.voyageRepository;
import com.aziz.voyages.service.voyageService;
@SpringBootTest
class VoyageApplicationTests {
@Autowired
private voyageRepository voyageRepository;
@Autowired
private voyageService voyageService;
@Test
public void testCreatevoyage() {
voyage voy = new voyage("turkey",2200.500,new Date());
voyageRepository.save(voy);
}


@Test
public void testFindvoyage()
{
voyage v = voyageRepository.findById(1L).get();
System.out.println(v);
}
@Test
public void testUpdatevoyage()
{
voyage v = voyageRepository.findById(1L).get();
v.setPrixvoyage(1000.0);
voyageRepository.save(v);
}
@Test
public void testDeletevoyage()
{
voyageRepository.deleteById(1L);;
}
@Test
public void testListerTousvoyages()
{
List<voyage> voys = voyageRepository.findAll();
for (voyage v : voys)

System.out.println(v);


} 
@Test
public void testFindvoyageByNom()
{
List<voyage> voys = voyageRepository.findByNomvoyage("turkey");
for (voyage v : voys)

System.out.println(v);
}

@Test
public void testFindvoyageByNomContains() {
	List<voyage> voys = voyageRepository.findByNomvoyageContains("t");
	for (voyage v : voys)

		System.out.println(v);
}
@Test
public void testfindByNomPrix()
{
List<voyage> voys = voyageRepository.findByNomPrix("turkey", 1000.0);
for (voyage v : voys)
{
System.out.println(v);
}
}
@Test
public void testfindByCategorie()
{
Categorie cat = new Categorie();
cat.setIdCat(1L);
List<voyage> voys = voyageRepository.findByCategorie(cat);
for (voyage v : voys)
{
System.out.println(v);
}
}
@Test
public void findByCategorieIdCat()
{
List<voyage> voys = voyageRepository.findByCategorieIdCat(1L);
for (voyage v : voys)
{
System.out.println(v);
}
 }

	@Test
	public void testfindByOrderByNomvoyageAsc() {
		List<voyage> voys = voyageRepository.findByOrderByNomvoyageAsc();
		for (voyage v : voys) {
			System.out.println(v);
		}
	}

	@Test
	public void testTriervoyagesNomsPrix() {
		List<voyage> voys = voyageRepository.triervoyagesNomsPrix();
		for (voyage v : voys) {
			System.out.println(v);
		}
	}

	@Test
public void testFindByNomvoyageContains()
{
	
Page<voyage> voys = voyageService.getAllvoyagesParPage(0,2);
System.out.println(voys.getSize());
System.out.println(voys.getTotalElements());
System.out.println(voys.getTotalPages());
voys.getContent().forEach(v -> {System.out.println(v.toString());
 });

}}


