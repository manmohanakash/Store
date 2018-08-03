package com.StoreApp.Repositorys;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.StoreApp.Models.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	
	public Optional<Customer> getCustomerByCustomerId(Integer customerId);

	public Optional<Customer> getCustomerByUserId(Integer customerId);
	
	
}
