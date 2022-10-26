package com.foh.twitterapp.dao;

import java.util.List;

import com.foh.twitterapp.entity.Authorities;
import com.foh.twitterapp.entity.User;

public interface IUserDAO {

	public List<User> getUsers();
	public void saveUser(User user, Authorities auth);
	public User getUser(String id);
	public void deleteUser(String id);
}
