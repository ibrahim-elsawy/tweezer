package com.foh.twitterapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foh.twitterapp.entity.Authorities;
import com.foh.twitterapp.entity.User;

@Repository
public class UserDAO implements IUserDAO{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user, Authorities auth) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		currentSession.saveOrUpdate(user);
		currentSession.saveOrUpdate(auth);
		
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub\
		Session currentSession = sessionFactory.getCurrentSession();
		List<User> user = currentSession.createQuery("FROM User s WHERE s.username='"+id+"'").getResultList();
//		User user = currentSession.get(User.class, id);
//		System.out.println(user.get(0));
		return (user.isEmpty()) ? null : user.get(0);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

}
