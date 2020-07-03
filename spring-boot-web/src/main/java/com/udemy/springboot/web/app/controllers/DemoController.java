package com.udemy.springboot.web.app.controllers;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;

@Controller //differences between @Controller and @RestController
@RequestMapping("/api")
public class DemoController 
{

	//@RequestMapping(value="/index", method=RequestMethod.GET) // ==> localhost:8080/index
	//@GetMapping("/index"), @PostMapping, @PutMapping, @DeleteMApping

	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) 		// implements java.util.map
	//public String index(ModelMap model) 	// extends LinkedHashMap<String, Object>
	{
		model.addAttribute("title_ModelMap", "Hello Spring!");
		return "index";
	}

	/* Option 2 : Map
	public String index(Map<String, Object> map)
	{
		map.put("title_Map", "Hello Spring! (Map)");
		return "index";
	} */
	
	/* Option 3 : Model-And-View
	public ModelAndView index(ModelAndView mv)
	{
		mv.addObject("title_ModelAndView", "Hello Spring! (ModelAndView)");
		mv.setViewName("index");
		return mv;
	} */
	
}
