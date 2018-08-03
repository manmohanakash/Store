package com.StoreApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.Customer;
import com.StoreApp.Repositorys.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository CustomerRepository;
	
	public Optional<Customer> getCustomerById(Integer customerId){
		return CustomerRepository.getCustomerByCustomerId(customerId);
	}
	
	public Optional<Customer> getCustomerByUserId(Integer userId){
		return CustomerRepository.getCustomerByUserId(userId);
	}

	public Customer addCustomer(Customer customer) {
		return CustomerRepository.save(customer);
	}
	
}
