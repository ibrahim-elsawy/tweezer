package com.foh.twitterapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.foh.twitterapp.entity.SentRes;


@Repository
public class SentDAO implements ISentDAO {
	
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SentRes> getAllSentRes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSentRes(SentRes sentRes) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(sentRes);

	}

	@Override
	public com.foh.twitterapp.entity.SentRes getSentRes(String dataID) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<SentRes> sentRes = currentSession.createQuery("FROM SentRes s WHERE s.dataID='"+dataID+"'").getResultList();
		return (sentRes.isEmpty()) ? null : sentRes.get(0);
	}

	@Override
	public void deleteSentRes(String dataID) {
		// TODO Auto-generated method stub

	}

}
