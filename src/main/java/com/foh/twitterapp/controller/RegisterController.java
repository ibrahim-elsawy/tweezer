package com.foh.twitterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.foh.twitterapp.dto.UserRegisterDTO;
import com.foh.twitterapp.entity.Authorities;
import com.foh.twitterapp.entity.User;
import com.foh.twitterapp.service.IUserService;
//import java.util.List;
import java.util.logging.Logger;

//import javax.validation.Valid;

//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	
	// need to inject our customer service
	@Autowired
	private IUserService userDetailsService;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	

	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("user", new UserRegisterDTO());
		return "registerForm";
	}

	@PostMapping("/processreg")
	public String processForm(@ModelAttribute("user") UserRegisterDTO userDTO, Model theModel) {
		
		System.out.println(userDTO);
		
		String userName = userDTO.getUsername();
		boolean userExists = doesUserExist(userName);
		
		if (userExists) {
			theModel.addAttribute("user", new UserRegisterDTO());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			
			return "registerForm";			
		}
		
		//
		// whew ... we passed all of the validation checks!
		// let's get down to business!!!
		//
		
		// encrypt the password
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;
                 
		Authorities authority = new Authorities(userName, "ROLE_USER");

        // create user object (from Spring Security framework)
        User tempUser = new User(userName, userDTO.getEmail(), encodedPassword);

        // save user in the database
        userDetailsService.saveUser(tempUser, authority);		
		
        logger.info("Successfully created user: " + userName);
        
		return "login";
	}
	
	private boolean doesUserExist(String userName) {
		
		logger.info("Checking if user exists: " + userName);
		
		// check the database if the user already exists
		boolean exists = userDetailsService.userExists(userName);
		
		logger.info("User: " + userName + ", exists: " + exists);
		
		return exists;
	}

}
