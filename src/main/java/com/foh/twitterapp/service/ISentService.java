package com.foh.twitterapp.service;

import java.util.List;

import com.foh.twitterapp.entity.SentRes;

public interface ISentService {
	
	public List<SentRes> getAllSentRes();
	public void saveSentRes(SentRes sentRes);
	public SentRes getSentRes(String dataID);
	public void deleteSentRes(String dataID);
	public boolean sentExists(String dataID);
}
