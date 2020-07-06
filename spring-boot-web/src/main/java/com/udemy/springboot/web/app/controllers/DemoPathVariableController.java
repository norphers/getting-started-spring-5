package com.udemy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class DemoPathVariableController 
{
	@GetMapping("/")
	public String index(Model model) 
	{
		model.addAttribute("title", "Sent param from URL (@PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{text}")
	public String pathVariables(@PathVariable(name="text") String text, Model model) 
	{
		model.addAttribute("title", "Request param from URL (@PathVariable)");
		model.addAttribute("result", "Text sent in the path variable: " + text);
		return "variables/view";
	}
	
	@GetMapping("/string/{text}/{number}")
	public String pathVariables(@PathVariable(name="text") String text, @PathVariable Integer number, Model model) 
	{
		model.addAttribute("title", "Request param from URL (@PathVariable)");
		model.addAttribute("result", "Text sent in the path variable: " + text + " Path Number: " + number);
		return "variables/view";
	}
}
