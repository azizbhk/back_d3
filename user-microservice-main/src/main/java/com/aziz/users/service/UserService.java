package com.aziz.users.service;

import java.util.List;

import com.aziz.users.entities.Role;
import com.aziz.users.entities.User;
import com.aziz.users.service.register.RegistrationRequest;


public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers();
	User registerUser(RegistrationRequest request);
	
	public void sendEmailUser(User u, String code);
	public User validateToken(String code);	
	
}