package com.StoreApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.User;
import com.StoreApp.Repositorys.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository UserRepository;
	

	public User addUser(User user) {
		return UserRepository.save(user);	
	}
	
	public Optional<User> getUserByUserName(String username) {
		return UserRepository.getUserByUserName(username);
	}
	
	public Optional<User> getUserByEmail(String email) {
		return UserRepository.getUserByEmail(email);
	}



}