package com.aziz.voyages;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.entities.voyage;
import com.aziz.voyages.service.voyageService;

@SpringBootApplication
public class VoyageApplication implements CommandLineRunner {
	@Autowired 
	voyageService voyageService;
	
	//@Autowired 
	//UserService userService;
	
	//@Autowired 
   // PasswordEncoder passwordEncoder;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(VoyageApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(voyage.class , Categorie.class);
		

	}
	

}
