package com.aziz.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.aziz.users.entities.Role;
import com.aziz.users.entities.User;
import com.aziz.users.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class UsersMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroservice2Application.class, args);
	}
	
	@Autowired
	UserService userService;
	
	/*
	@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"youssef","123",true,null));
	userService.saveUser(new User(null,"yassine","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("admin", "USER");
	userService.addRoleToUser("youssef", "USER");
	userService.addRoleToUser("yassine", "USER");
	}
	*/
	/*
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}
	*/

}
