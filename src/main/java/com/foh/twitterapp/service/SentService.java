package com.foh.twitterapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foh.twitterapp.dao.ISentDAO;
import com.foh.twitterapp.entity.SentRes;


@Service
public class SentService implements ISentService {
	
	@Autowired
	private ISentDAO sentDAO;

	@Override
	@Transactional
	public List<SentRes> getAllSentRes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveSentRes(SentRes sentRes) {
		sentDAO.saveSentRes(sentRes);
	}

	@Override
	@Transactional
	public SentRes getSentRes(String dataID) {
		return sentDAO.getSentRes(dataID);
	}

	@Override
	@Transactional
	public void deleteSentRes(String dataID) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public boolean sentExists(String dataID) {
		return (getSentRes(dataID) != null) ? true : false;
	}

}
