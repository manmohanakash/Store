package com.StoreApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.User;
import com.StoreApp.Repositorys.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository UserRepository;
	

	public User addUser(User user) {
		try {
			return UserRepository.save(user);
		}
		catch (JpaSystemException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public User updateUser(User user) {
		return UserRepository.save(user);	
	}
	
	public Optional<User> getUserByUserId(Integer userId) {
		return UserRepository.getUserByUserId(userId);
	}
	
	public Optional<User> getUserByUserName(String userName) {
		return UserRepository.getUserByUserName(userName);
	}
	
	public Optional<User> getUserByEmail(String userEmail) {
		return UserRepository.getUserByEmail(userEmail);
	}
	
	public Optional<User> getUserByCustomerId(Integer customerId) {
		return UserRepository.getUserByCustomerCustomerId(customerId);
	}
	
	
	
	
	/**
	 * Validates if any important fields(UserName,FirstName,LastName,Password) are missing.
	 * @param user
	 * @return true or false
	 */
	public String validateFields(User user) {
		
		if(user==null ||   
				user.getUserName()==null ||	user.getUserName().equals("") ||
				user.getPassword()==null || user.getPassword().equals("") ||
				user.getEmail()==null || user.getEmail().equals(""))
			return "Fields cannot be empty";
		else if(!user.getUserName().matches("^[A-Za-z_][A-Za-z\\d_]*$")) 
			return "Username should be alphabets";
		else if(getUserByUserName(user.getUserName()).isPresent())
			return "Username already exists";
		else if(getUserByEmail(user.getEmail()).isPresent())
				return "Email already exists";
		
		return "success";
	}


	

}