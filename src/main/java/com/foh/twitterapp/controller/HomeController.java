package com.foh.twitterapp.controller;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.foh.twitterapp.dto.HomeDTO;
import com.foh.twitterapp.dto.KafkaDTO;
import com.foh.twitterapp.service.IKafkaService;



@Controller
public class HomeController {
	
	@Autowired
	private IKafkaService kafkaService;
	
	@GetMapping("/home")
	public String showHome(Model model) {
		model.addAttribute("home", new HomeDTO());
		return "home";
	}
	
	@PostMapping("/home")
	public String processRequest(@ModelAttribute("home") HomeDTO home, Model model) {
		String msgID = randomString();
		kafkaService.sendMessage(home.getKeyword() + "#*#" + msgID, "main3");
		KafkaDTO kafka_info = new KafkaDTO(msgID);
		model.addAttribute("kafka_info", kafka_info);	
		return "home";
	}
	
	public String randomString() {
		
	    String generatedString = RandomStringUtils.randomAlphanumeric(10);
	    System.out.println(generatedString);
	    return generatedString;
	}


}
