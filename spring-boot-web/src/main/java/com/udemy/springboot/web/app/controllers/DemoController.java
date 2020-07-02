package com.udemy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //differences between @Controller and @RestController
public class DemoController 
{
	//@RequestMapping(value="/index", method=RequestMethod.GET) // ==> localhost:8080/index
	//@GetMapping("/index"), @PostMapping, @PutMapping, @DeleteMApping
	@GetMapping({"/index", "/", "/home"})
	public String Index()
	{
		return "index";
	}

}
