package com.foh.twitterapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SentRes")
public class SentRes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dataID")
	private String dataID;
	
	@Column(name="postive")
	private int postive;
	
	@Column(name="neutral")
	private int neutral;
	
	@Column(name="negative")
	private int negative;

	public SentRes() {
		// TODO Auto-generated constructor stub
	}

	public SentRes( String dataID, int postive, int neutral, int negative) {
		this.dataID = dataID;
		this.postive = postive;
		this.neutral = neutral;
		this.negative = negative;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataID() {
		return dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}

	public int getPostive() {
		return postive;
	}

	public void setPostive(int postive) {
		this.postive = postive;
	}

	public int getNeutral() {
		return neutral;
	}

	public void setNeutral(int neutral) {
		this.neutral = neutral;
	}

	public int getNegative() {
		return negative;
	}

	public void setNegative(int negative) {
		this.negative = negative;
	}

	@Override
	public String toString() {
		return "SentRes [id=" + id + ", dataID=" + dataID + ", postive=" + postive + ", neutral=" + neutral
				+ ", negative=" + negative + "]";
	}


	
	
	
}
