package com.foh.twitterapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.foh.twitterapp.entity.SentRes;

@Service
public class KafkaService implements IKafkaService {
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ISentService sentService;
	

	@Override
	public void sendMessage(String message, String topicName) {
		
	    ListenableFuture<SendResult<String, String>> future = 
	    	      kafkaTemplate.send(topicName, message);
	    		
	    	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	    	        @Override
	    	        public void onSuccess(SendResult<String, String> result) {
	    	            System.out.println("Sent message=[" + message + 
	    	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	    	        }
	    	        @Override
	    	        public void onFailure(Throwable ex) {
	    	            System.out.println("Unable to send message=[" 
	    	              + message + "] due to : " + ex.getMessage());
	    	        }
	    	    });

	}

	@Override
	@KafkaListener(topics = "main4", groupId = "spring-app")
	public void listenGroupFoo(String message) {
		SentRes retrievedStudent;
	    System.out.println("Received Message : " + message);
	    String [] msg = message.split("#*#");
//	    System.out.println("========================="+msg[0]+"==========================="+msg[1]);
	    if(sentService.sentExists(msg[2])) {
	    	retrievedStudent = sentService.getSentRes(msg[2]);
	    }
	    else {
	    	retrievedStudent = new SentRes(msg[2], 0, 0, 0);
	    }
	    
	    switch (msg[0]) {
	    
	    case "NEU":
	      System.out.println("it's NEU tweet.......");
	      retrievedStudent.setNeutral(retrievedStudent.getNeutral()+1);
	      break;
	    case "POS":
	      System.out.println("it's POS tweet........");
	      retrievedStudent.setPostive(retrievedStudent.getPostive()+1);
	      break;
	    case "NEG":
	    	System.out.println("it's NEG tweet........");
	    	retrievedStudent.setNegative(retrievedStudent.getNegative()+1);
	    default:
	      System.out.println("no matching for incoming msg!======="+msg[0]);
	  }
	    sentService.saveSentRes(retrievedStudent);

	}

}
