package com.foh.twitterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.foh.twitterapp.entity.User;
import com.foh.twitterapp.service.IUserService;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
