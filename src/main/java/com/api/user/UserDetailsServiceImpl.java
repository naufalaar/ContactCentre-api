package com.api.user;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.entity.ApplicationUser;
import com.api.repository.ApplicationUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	ApplicationUserRepository applicationUserRepository;
	
	

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), new ArrayList<>());
		
		
		
	}
	
	

}
