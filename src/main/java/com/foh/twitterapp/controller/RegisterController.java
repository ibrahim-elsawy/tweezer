package com.foh.twitterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.foh.twitterapp.entity.User;
import com.foh.twitterapp.service.IUserService;


@Controller
public class RegisterController {
	
	// need to inject our customer service
	@Autowired
	private IUserService userService;

	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return "registerForm";
	}

	@PostMapping("/processreg")
	public String processForm(@ModelAttribute("user") User user) {
		System.out.println(user);
		userService.saveUser(user);
		return "login";
	}

}
