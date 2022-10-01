package com.foh.twitterapp.dao;

import java.util.List;

import com.foh.twitterapp.entity.User;

public interface IUserDAO {

	public List<User> getUsers();
	public void saveUser(User user);
	public User getUser(int id);
	public void deleteUser(int id);
}
