package com.mvcblogs.blog.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		if (!model.containsAttribute("post")) {
			model.addAttribute("post", new Post());
		}
		return "post/list";
	}
	
	@GetMapping("/posts/{postid}")
	public String show(Model model, @PathVariable("postid") Long postId) {
		Optional<Post> postData = postRepository.findById(postId);
		if (postData.isPresent()) {
			Post post = postData.get();
			model.addAttribute("title", post.getTitle());
			model.addAttribute("description", post.getDescription());
			model.addAttribute("post", post);
			return "post/show";
		}
		return "redirect:/posts";
	}
	
	@PostMapping("/posts/save")
	public String save(Model model, @Valid Post post, BindingResult result, RedirectAttributes attrs) {
		if (result.hasErrors()) {
			attrs.addFlashAttribute("org.springframework.validation.BindingResult.post", result);
		    attrs.addFlashAttribute("post", post);
			return "redirect:/posts";
		}
		postRepository.save(post);
		return "redirect:/posts";
	}
	
}
