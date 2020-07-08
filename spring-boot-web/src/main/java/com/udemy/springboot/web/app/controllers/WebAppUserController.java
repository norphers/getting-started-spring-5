package com.udemy.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.springboot.web.app.models.WebAppUser;

@Controller
@RequestMapping("/api")
public class WebAppUserController 
{
	@Value("${text.webAppUserController.home.title}")
	private String homeTitle;
	
	@Value("${text.webAppUserController.user-profile.title}")
	private String userProfileTitle;
	
	@Value("${text.webAppUserController.user-list.title}")
	private String userListTitle;
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model)
	{
		model.addAttribute("title", homeTitle);
		return "index";
	}
	
	@RequestMapping("/user-profile")
	public String profile(Model model)
	{
		WebAppUser user = new WebAppUser();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john.doe@example.com");
		
		model.addAttribute("user", user);
		model.addAttribute("title", userProfileTitle + ": " + user.getFirstName());
		
		return "user-profile";
	}
	
	@RequestMapping("/user-list")
	public String list(Model model)
	{
		model.addAttribute("title", userListTitle);
		return "list";
	}
	
	@ModelAttribute("users") // se utiliza para pasar datos al View y rellenar por ejemplo, campos de un SELECT en un formulario 
	public List<WebAppUser> createUsers()
	{
		List<WebAppUser> users = new ArrayList<>();
		users.add(new WebAppUser("Bilbo", "Baggins", "bilbo.baggins@demo.com"));
		users.add(new WebAppUser("Frodo", "Baggins", "frodo.baggins@demo.com"));
		users.add(new WebAppUser("Samwise", "Gamgee", "samwise.gamgee@demo.com"));
		
		return users;
	}
}