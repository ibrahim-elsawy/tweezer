package com.foh.twitterapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foh.twitterapp.dao.IUserDAO;
import com.foh.twitterapp.entity.Authorities;
import com.foh.twitterapp.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveUser(User user, Authorities auth) {
		// TODO Auto-generated method stub
		userDAO.saveUser(user, auth);

	}

	@Override
	@Transactional
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return (getUser(username) != null) ? true : false;
	}

}
