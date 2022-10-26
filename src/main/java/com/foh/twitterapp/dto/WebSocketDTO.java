package com.foh.twitterapp.dto;

public class WebSocketDTO {
	
	private String data;
	private boolean finished;
	
	
	
	public WebSocketDTO() {
		// TODO Auto-generated constructor stub
	}



	public WebSocketDTO(String data, boolean finished) {
		this.data = data;
		this.finished = finished;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public boolean isFinished() {
		return finished;
	}



	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	
	
	

}
