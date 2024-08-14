package com.oracle.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oracle.project.MyUserDetails;
import com.oracle.project.pojo.User;
import com.oracle.project.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;
	Optional<User> userRef;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<User> user=userRepository.findByUserName(username);
		if(user.isPresent())
		{
				userRef=user;
				return user.map(MyUserDetails::new).get();
		}
		else
		{
			throw new RuntimeException("User not found");
		}

	}
	
	public String getUsername()
	{
		return userRef.get().getUserName();
	}

}
