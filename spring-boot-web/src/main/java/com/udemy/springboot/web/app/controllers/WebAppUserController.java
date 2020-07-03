package com.udemy.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.springboot.web.app.models.WebAppUser;

@Controller
@RequestMapping("/api")
public class WebAppUserController 
{
	@RequestMapping("/user-profile")
	public String profile(Model model)
	{
		WebAppUser user = new WebAppUser();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john.doe@example.com");
		
		model.addAttribute("user", user);
		model.addAttribute("title", "User profile: ".concat(user.getFirstName()));
		
		return "user-profile";
	}
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		List<WebAppUser> users = new ArrayList<>();
		users.add(new WebAppUser("Bilbo", "Baggins", "bilbo.baggins@demo.com"));
		users.add(new WebAppUser("Frodo", "Baggins", "frodo.baggins@demo.com"));
		users.add(new WebAppUser("Samwise", "Gamgee", "samwise.gamgee@demo.com"));
		
		model.addAttribute("title", "User list");
		model.addAttribute("users", users);
		
		return "list";
	}
}
