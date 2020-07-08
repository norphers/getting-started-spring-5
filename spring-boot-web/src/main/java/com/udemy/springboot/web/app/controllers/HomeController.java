package com.udemy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//"redirect:https://google.com"; --> cambia la URL perque la redirigeix
		return "forward:/api/index"; // --> no cambia la URL però et dredirigeix
	}

}
