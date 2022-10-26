package com.foh.twitterapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.foh.twitterapp.dto.SentimentDTO;
import com.foh.twitterapp.entity.SentRes;
import com.foh.twitterapp.service.ISentService;

@RestController
//@CrossOrigin
public class SentimentController {
	
	@Autowired
	private ISentService sentService;
	
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/sentiment/{dataID}")
	public SentimentDTO getSentiment(@PathVariable String dataID) {
		
		if(sentService.sentExists(dataID)) {
			
			SentRes retrievedStudent = sentService.getSentRes(dataID);
			SentimentDTO res = new SentimentDTO(
					retrievedStudent.getNeutral(), 
					retrievedStudent.getPostive(), 
					retrievedStudent.getNegative());
			res.setStatus(true);
			return res;
		}
		else {
			SentimentDTO res = new SentimentDTO();
			res.setStatus(false);
			return res;
		}

	    
		
	}

}
