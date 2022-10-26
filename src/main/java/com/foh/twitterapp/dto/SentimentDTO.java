package com.foh.twitterapp.dto;

public class SentimentDTO {
	
	private int neutral;
	private int postive;
	private int negative;
	private boolean status;
	
	
	public SentimentDTO() {
		// TODO Auto-generated constructor stub
	}


	

	public SentimentDTO(int neutral, int postive, int negative) {
		this.neutral = neutral;
		this.postive = postive;
		this.negative = negative;
		this.status = false;
	}




	public int getNeutral() {
		return neutral;
	}


	public void setNeutral(int neutral) {
		this.neutral = neutral;
	}


	public int getPostive() {
		return postive;
	}


	public void setPostive(int postive) {
		this.postive = postive;
	}


	public int getNegative() {
		return negative;
	}


	public void setNegative(int negative) {
		this.negative = negative;
	}

	
	
	
	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "SentimentDTO [neutral=" + neutral + ", postive=" + postive + ", negative=" + negative + ", status="
				+ status + "]";
	}
	
	
	
	

}
