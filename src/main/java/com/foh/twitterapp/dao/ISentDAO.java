package com.foh.twitterapp.dao;

import java.util.List;


import com.foh.twitterapp.entity.SentRes;



public interface ISentDAO {
	
	public List<SentRes> getAllSentRes();
	public void saveSentRes(SentRes sentRes);
	public SentRes getSentRes(String dataID);
	public void deleteSentRes(String dataID);

}
