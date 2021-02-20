package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
	
	@Query(value = "SELECT c.id FROM customer c, customer_store cs, store s WHERE c.id = cs.customer_id and cs.store_id = s.id and c.id = :customerNumber and s.store_number = :storeNumber",
	        nativeQuery = true)
	long findByIdAndCustomerStores(@Param("customerNumber") long id,
	                        @Param("storeNumber") int storeNumber);
	
}
