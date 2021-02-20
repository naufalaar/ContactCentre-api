package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Customer;
import com.api.entity.CustomerStore;
import com.api.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepostiory;
	
	public List<Customer> findCustomers(String firstName, String lastName){
		return customerRepostiory.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
	}
	
	
	public Customer findCustomer(long id, int storeNumber){
		long customerId =  customerRepostiory.findByIdAndCustomerStores(id, storeNumber);
		return customerRepostiory.findById(customerId).get();
	}
	

}
