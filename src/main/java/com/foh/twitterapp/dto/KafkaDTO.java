package com.foh.twitterapp.dto;

public class KafkaDTO {
	
	private String MsgID;

	public KafkaDTO() {
		// TODO Auto-generated constructor stub
	}

	public KafkaDTO(String msgID) {
		MsgID = msgID;
	}

	public String getMsgID() {
		return MsgID;
	}

	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
	

}
