package com.foh.twitterapp.service;

public interface IKafkaService {
	
	public void sendMessage(String message, String topicName);
	public void listenGroupFoo(String message);

}
