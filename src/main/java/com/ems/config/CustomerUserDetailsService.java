package com.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ems.dao.UserDAO;
import com.ems.entity.User;
@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UserDAO   userDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userDao.findUserByEmail(email);
		System.out.println("userdetailsserviice called");
		System.out.println(email);
		System.out.println(user.getPassword());
		System.out.println(user.getRole().name());
		
		return  org.springframework.security.core.userdetails.User
				.withUsername(user.getEmail())
				.password(user.getPassword())
				.authorities(user.getRole().name())
				.build();
	}

}
