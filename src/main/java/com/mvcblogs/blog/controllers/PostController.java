package com.mvcblogs.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvcblogs.blog.models.PostRepository;
import com.mvcblogs.blog.models.Post;

@Controller
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public String list(Model model) {
		model.addAttribute("title", "Posts");
		model.addAttribute("description", "List of posts");
		model.addAttribute("posts", postRepository.findAll());
		return "post/list";
	}
	
}
