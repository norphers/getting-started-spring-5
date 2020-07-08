package com.udemy.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class DemoPathParamsController 
{
	@GetMapping("/")
	public String index()
	{
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="text", required=false, defaultValue = "default value") String text, Model model)
	{
		model.addAttribute("result", "Text: " + text);
		return "params/view";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String greetings, @RequestParam Integer number, Model model)
	{
		model.addAttribute("result", "Greetings: " + greetings + ". Number: " + number);
		return "params/view";
	}
	
	@GetMapping("/mix-params-legacy")
	public String param(HttpServletRequest request, Model model)
	{
		String greetings = request.getParameter("greetings");
		Integer number = null;
		try {
			number = Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
			number = 0;
		}
		model.addAttribute("result", "Greetings: " + greetings + ". Number: " + number);
		return "params/view";
	}

}
