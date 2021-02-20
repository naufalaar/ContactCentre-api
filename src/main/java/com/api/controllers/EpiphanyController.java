package com.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.ApplicationUser;
import com.api.entity.Customer;
import com.api.entity.CustomerResult;
import com.api.entity.CustomerSearch;
import com.api.entity.CustomerStore;
import com.api.repository.ApplicationUserRepository;
import com.api.repository.CustomerRepository;
import com.api.service.CustomerService;

@RestController
@RequestMapping("/")
public class EpiphanyController {
	
	private ApplicationUserRepository applicationUserRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CustomerService customerService;
	
    
	
	public EpiphanyController(BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserRepository applicationUserRepository) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.applicationUserRepository = applicationUserRepository;
	}


	@PostMapping("/searchCustomers")
	List<CustomerResult> searchCustomers(@RequestBody CustomerSearch customerSearch){
		List<Customer> customers = customerService.findCustomers(customerSearch.getFirstName(), customerSearch.getLastName());
		List<CustomerResult> customerResults = new ArrayList<CustomerResult>();
 		for (Customer customer: customers)
			customerResults.add(new CustomerResult(customer));
		return customerResults;
	}
	
	@GetMapping("/searchCustomer")
	Customer searchCustomer() {
		return customerService.findCustomer(1,1462); 
	}
	
	@PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

}
