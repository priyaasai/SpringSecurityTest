package com.oracle.project;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oracle.project.pojo.User;

public class MyUserDetails implements UserDetails {

	List<GrantedAuthority> grantedAuthorities;
	String username;
	String password;
	boolean active;
	
	public MyUserDetails(User user) 
	{
		super();
		this.grantedAuthorities=Arrays.stream(user.getRoles().split(","))
				  				.map(SimpleGrantedAuthority::new)
				  				.collect(Collectors.toList());
		this.username = user.getUserName();
		this.password = user.getUserPassword();
		this.active=user.isActive();
	}
	
	public MyUserDetails() 
	{
		super();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	@Override
	 public boolean isAccountNonExpired() {
	  // TODO Auto-generated method stub
	  System.out.println("isAccountNonExpired() : ");

	  return true;
	 }

	 @Override
	 public boolean isAccountNonLocked() {
	  // TODO Auto-generated method stub
	  System.out.println("isAccountNonLocked() : ");
	  return true;
	 }

	 @Override
	 public boolean isCredentialsNonExpired() {
	  // TODO Auto-generated method stub
	  System.out.println("isCredentialsNonExpired() : ");
	  return true;
	 }

	 @Override
	 public boolean isEnabled() {
	  // TODO Auto-generated method stub
	  System.out.println("isEnabled() : "+active);
	  return active;
	 }

}
