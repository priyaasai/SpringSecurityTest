package com.oracle.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserResource 
{
	@GetMapping
	public String home()
	{
		return "home";
		//home.html
	}
	
	@GetMapping("/user")
	public String user()
	{
		return "userPage";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "adminPage";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return "redirect:/user" ;
	}
	
}
