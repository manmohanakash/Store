package com.StoreApp.Repositorys;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.StoreApp.Models.User;



public interface UserRepository extends CrudRepository<User,Integer>{

	public Optional<User> getUserByUserId(Integer userId);

	public Optional<User> getUserByUserName(String userName);

	public Optional<User> getUserByEmail(String email);

	public Optional<User> getUserByCustomerCustomerId(Integer customerId);
	
	
}