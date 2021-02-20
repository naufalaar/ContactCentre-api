package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String username);
	
}
