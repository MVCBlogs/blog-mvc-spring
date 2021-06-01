package com.mvcblogs.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Blog - Spring");
		model.addAttribute("description", "A clean blog with an MVC architecture in Spring");
		return "home/index";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About us");
		model.addAttribute("description", "Information about the developers of this application");
		return "home/about";
	}
}
